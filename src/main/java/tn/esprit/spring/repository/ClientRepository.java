package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Client;





@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query("select SUM(c.salaire) from Client c")
	public Float GetMoyenneDesSalaires();
}
