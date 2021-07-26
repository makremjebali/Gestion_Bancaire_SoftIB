package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, String>{

	@Query("SELECT c.Compte_identifiant,MAX(c.Solde) "
			+ "from Compte c ORDER BY MAX(c.Solde) ASC ")
	public List<String> GetNumerosComptePlusGrandSoldeASC ();
	@Query("SELECT c.Compte_identifiant,MIN(c.Solde) "
			+ "from Compte c ORDER BY MIN(c.Solde) ASC ")
	public List<String> GetNumerosComptePlusPetitSoldeASC();
	

	

}
