package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.Entity.Historique;
import tn.esprit.spring.Entity.Operation;
import tn.esprit.spring.Entity.Retrait;
import tn.esprit.spring.Entity.Versement;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.HistoriqueRepository;
import tn.esprit.spring.repository.OperationRepository;


@Service
@Transactional
public class CompteService implements ICompteService {
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	HistoriqueRepository historiqueRepository;
	private static final Logger l = LogManager.getLogger(CompteService.class);
	@Override
	public Compte consulterCompte(String codecompte) {
		Compte cpt =  compteRepository.findById(codecompte).get();
		if (cpt == null)
		{
			l.info("Compte introvable");
		}
		return cpt;
	}

	@Override
	public void versement(String codecompte, double montant) {
		// TODO Auto-generated method stub
		Compte cpt = consulterCompte(codecompte);
		Versement ver = new Versement(new Date(), montant, cpt);
		operationRepository.save(ver);
		cpt.setSolde(cpt.getSolde()+montant);
		compteRepository.save(cpt);
		Historique his = new Historique(new Date(), "versement", "versement", montant, cpt.getSolde());
		historiqueRepository.save(his);
	}

	@Override
	public void retrait(String codecompte, double montant) {
		Compte cpt = consulterCompte(codecompte);
		double facilitesretrait=0;
		if (cpt instanceof CompteCourant)
			facilitesretrait=((CompteCourant)cpt).getDecouvert();
		if (cpt.getSolde()+facilitesretrait<montant)
			l.info("solde insuffisant");
		Retrait ret = new Retrait(new Date(), montant, cpt);
		operationRepository.save(ret);
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
		Historique his = new Historique(new Date(), "retrait", "retrait", montant, cpt.getSolde());
		historiqueRepository.save(his);
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
		//return operationRepository.listoperation(codecompte);
		return null;
	}
}
