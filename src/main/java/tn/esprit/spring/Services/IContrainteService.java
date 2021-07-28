package tn.esprit.spring.Services;

import java.util.List;
import tn.esprit.spring.Entity.Contrainte;


public interface IContrainteService {

	public void AddContrainte(Contrainte c);
	public Contrainte UpdateContrainte(Contrainte c,long idcontrainte);
	public void DeleteContrainte(long idcontrainte);
	public List<Contrainte> retrieveAllContrainte() ;
}
