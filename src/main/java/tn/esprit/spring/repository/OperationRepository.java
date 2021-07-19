package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Operation;


@Repository
public interface OperationRepository extends CrudRepository<Operation, Long>{

	/*@Query("select o from Operation owhere o.compte.Compte_identifiant=:x order by o.Date_ouverture desc")
	public List<Operation> listoperation(@Param("x")String codecompte);
*/
}
