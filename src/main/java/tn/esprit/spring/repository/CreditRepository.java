package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Entity.Credit;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
		
	@Query("select SUM(c.montant) from Credit c")
	public float sommeCrédits();
}
