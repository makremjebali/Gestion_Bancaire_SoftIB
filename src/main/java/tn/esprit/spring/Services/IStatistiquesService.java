package tn.esprit.spring.Services;

import java.util.List;


public interface IStatistiquesService {

	public List<String>  GetNumerosComptePlusGrandSoldeASC();
	
	public List<String>  GetNumerosComptePlusPetitSoldeASC();
	
	public int GetNombreDecompteParType(); 
	
	public double GetSommeDesCrédits();
	
	public double CalculeTMM();
	
	public double GetMoyenneDesSalaires();
	
	
}
