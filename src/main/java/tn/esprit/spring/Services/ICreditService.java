package tn.esprit.spring.Services;




public interface ICreditService {

	
	public void demanderCredit(String CodeCompte,Long CodeClient,Long idCredit,Long idcontrainte,
			String typecredit);
	
	public String GetTMMFromSitebct();
	
	
}
