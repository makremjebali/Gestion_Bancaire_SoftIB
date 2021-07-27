package tn.esprit.spring.Services;

import java.util.List;
import tn.esprit.spring.Entity.Credit;

public interface ICreditService {
	public void demanderCredit(String CodeCompte,Long CodeClient,Long idcontrainte);
	
	public String GetTMMFromSitebct();
	public void deletedemandeCredit(Long id);
	public Credit AfficheCreditbyId(long id);
	public List<Credit> AfficheAllCredit();
	public void UpadtedemandeCredit(Long id, Credit c);
}
