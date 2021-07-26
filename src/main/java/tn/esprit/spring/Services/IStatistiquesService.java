package tn.esprit.spring.Services;

import java.util.List;



public interface IStatistiquesService {

	public List<String>  GetNumerosComptePlusGrandSoldeASC();
	
	public List<String>  GetNumerosComptePlusPetitSoldeASC();
	
	public List<String> GetNombreDecompteParType(); 
	
	public Float GetSommeDesCrédits();
	
	public String CalculeTMM();
	
	public double GetMoyenneDesSalaires();
	
	
}
