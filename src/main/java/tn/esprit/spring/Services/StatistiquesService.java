package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.CreditRepository;

@Service
public class StatistiquesService implements IStatistiquesService {

	@Autowired
	CompteRepository compteRepository;
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	CreditRepository creditrepository;
	@Autowired
	ClientService clientservice;
	@Autowired
	CompteService compteservice;
	@Autowired
	CreditService creditservice;

	
	@Override
	public List<String> GetNumerosComptePlusGrandSoldeASC() {
		List<Compte> listcompte=compteservice.listCompte();
		double max=0;
		String Numer_compte="";
		for (Compte i:listcompte){
			if (i.getSolde()>max)
			{
			max=i.getSolde();
			
			Numer_compte = i.getCompte_identifiant();
			}
		}
		List<String> NumerosComptePlusGrand=new ArrayList<>();
		NumerosComptePlusGrand.add("les numéros de compte ayant le plus grand solde est " 
		+ Numer_compte 
				+ " est sont solde est " + max);
		return NumerosComptePlusGrand;
	}

	@Override
	public List<String>  GetNumerosComptePlusPetitSoldeASC() {
		
		return compteRepository.GetNumerosComptePlusPetitSoldeASC();
	}

	@Override
	public List<String> GetNombreDecompteParType() {
		int nbrCompteCourant = 0 ;
		int nbrCompteEpargne=0;
		List<Compte> listcompte=compteservice.listCompte();
		//listcompte.add(compteRepository.GetNombreDecompteParType());
		
		for (Compte i:listcompte){
		if (i instanceof CompteCourant)
		{
			nbrCompteCourant++;
		}
		else 
			nbrCompteEpargne++;
		}
		
		List<String> listtype=new ArrayList<>();
		listtype.add("le nomber de Compte Courant est " + nbrCompteCourant 
				+ " est  le nomber de Compte Epargne est " + nbrCompteEpargne);
		
			return listtype;
		
	}

	@Override
	public Float GetSommeDesCrédits() {
		List<Client> listClient=clientservice.retrieveAllClients();
		float somme=creditrepository.sommeCrédits();
			return somme;
	}

	@Override
	public String CalculeTMM() {
		// TODO Auto-generated method stub
		return creditservice.GetTMMFromSitebct();
		//return "";
	}

	@Override
	public double GetMoyenneDesSalaires() {
		// TODO Auto-generated method stub
		return clientrepository.GetMoyenneDesSalaires();
	}

}
