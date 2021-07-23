package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.repository.CompteRepository;

@Service
public class StatistiquesService implements IStatistiquesService {

	@Autowired
	CompteRepository compteRepository;
	
	@Override
	public List<String>  GetNumerosComptePlusGrandSoldeASC() {
		
		return compteRepository.GetNumerosComptePlusGrandSoldeASC();
	}

	@Override
	public List<String>  GetNumerosComptePlusPetitSoldeASC() {
		// TODO Auto-generated method stub
		 return compteRepository.GetNumerosComptePlusPetitSoldeASC();
	}

	@Override
	public int GetNombreDecompteParType() {
		// TODO Auto-generated method stub
		
		//List<Compte> listcpte =new ArrayList<>();
			//listcpte.addAll(compteRepository.findAll());	
		
		int nbrcomptecourant = 0 ;
		Compte cpt = (Compte) compteRepository.findAll();
		if (cpt instanceof CompteCourant)
		{
			nbrcomptecourant++;
		}
	
		
			return nbrcomptecourant;
		
	}

	@Override
	public double GetSommeDesCrédits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double CalculeTMM() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double GetMoyenneDesSalaires() {
		// TODO Auto-generated method stub
		return compteRepository.GetMoyenneDesSalaires();
	}

}
