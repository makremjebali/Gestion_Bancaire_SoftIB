package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.Entity.Historique;
import tn.esprit.spring.Entity.Operation;
import tn.esprit.spring.Entity.Retrait;
import tn.esprit.spring.Entity.Versement;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.HistoriqueRepository;
import tn.esprit.spring.repository.OperationRepository;
import tn.esprit.spring.repository.factureRepository;


@Service
@Transactional
public class CompteService implements ICompteService {
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	HistoriqueRepository historiqueRepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	factureRepository factureRepository;
	private static final Logger l = LogManager.getLogger(CompteService.class);
	@Override
	public Compte consulterCompte(String codecompte) {
		Compte cpt =  compteRepository.findById(codecompte).get();
		if (cpt == null)
		{
			throw new RuntimeException("Compte introuvable");
		}
		return cpt;
	}

	@Override
	public void versement(String codecompte, double montant) {
		// TODO Auto-generated method stub
		Compte cpt = consulterCompte(codecompte);
		cpt.setSolde(cpt.getSolde()+montant);
		compteRepository.save(cpt);
		Historique his = new Historique(new Date(), "versement", "versement", montant, cpt.getSolde(),cpt);
		Versement ver = new Versement(new Date(), montant, cpt, his);
		Long num_Facture = ThreadLocalRandom.current().nextLong(11111111, 99999999);
		Facture fac = new Facture(num_Facture, new Date(), cpt.getClients());
		operationRepository.save(ver);
		historiqueRepository.save(his);
		factureRepository.save(fac);
	}

	@Override
	public void retrait(String codecompte, double montant) {
		Compte cpt = consulterCompte(codecompte);
		double facilitesCaisse=0;
		if (cpt instanceof CompteCourant)
			facilitesCaisse=((CompteCourant)cpt).getDecouvert();
		if (cpt.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde insuffisant");
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
		Historique his = new Historique(new Date(), "retrait", "retrait", montant, cpt.getSolde(),cpt);
		Retrait ret = new Retrait(new Date(), montant, cpt,his);
		Long num_Facture = ThreadLocalRandom.current().nextLong(11111111, 99999999);
		Facture fac = new Facture(num_Facture, new Date(), cpt.getClients());
		operationRepository.save(ret);
		historiqueRepository.save(his);
		factureRepository.save(fac);
	}

	@Override
	public void virement(String codecompte1, String codecompte2, double montant) {
		// TODO Auto-generated method stub
		retrait(codecompte1, montant);
		versement(codecompte2, montant);
	}

	@Override
	public List<Operation> listoperation(String codecompte) {
		// TODO Auto-generated method stub
		
		return operationRepository.listoperation(codecompte);
	}

	@Override
	public Compte addCompte(Compte c,Long idAgence,Long code_client) {
		// TODO Auto-generated method stub
		Agence a = agenceRepository.findById(idAgence).get();
		Client client = clientRepository.findById(code_client).get();
		c.setAgence(a);
		c.setClients(client);
		c.setDate_ouverture(new Date());
		return compteRepository.save(c);
	}

	@Override
	public List<Compte> listCompte() {
		// TODO Auto-generated method stub
		return (List<Compte>) compteRepository.findAll();
	}

	@Override
	public Compte GetCompte(String code_cpte) {
		// TODO Auto-generated method stub
		return compteRepository.findById(code_cpte).get();
	}
}
