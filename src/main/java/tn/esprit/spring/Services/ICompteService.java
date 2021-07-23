package tn.esprit.spring.Services;


import java.util.List;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Operation;




public interface ICompteService {
	public Compte consulterCompte(String codecompte);
	public List<Compte> listCompte ();
	public void versement(String codecompte ,double montant);
	public void retrait (String codecompte ,double montant);
	public void virement(String codecompte1,String codecompte2,double montant);
	public List<Operation> listoperation(String codecompte);
	public Compte addCompte(Compte c,Long idAgence,Long code_client);
	public Compte GetCompte(String code_cpte);
	
	
}
