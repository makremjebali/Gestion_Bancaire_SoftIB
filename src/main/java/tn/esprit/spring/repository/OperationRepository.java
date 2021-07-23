package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Operation;


@Repository
public interface OperationRepository extends CrudRepository<Operation, Long>{

	@Query("select o from Operation o where o.compte.Compte_identifiant=:x")
	public List<Operation> listoperation(@Param("x")String codecompte);
	
	@Query("select SUM(o.montant) from Operation o where o.date_opertaion=:d")
	public double GetMoyenneDesTransactions(@Param("d")Date datejour);
	
}
