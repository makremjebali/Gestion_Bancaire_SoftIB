package tn.esprit.spring.Services;

import java.util.List;
import tn.esprit.spring.Entity.Contrainte;


public interface IContrainteService {

	public void AddContrainte(Contrainte c,long idcontrainte);
	public Contrainte UpdateContrainte(long idcontrainte);
	public void DeleteContrainte(long idcontrainte);
	public List<Contrainte> retrieveAllContrainte() ;
}
