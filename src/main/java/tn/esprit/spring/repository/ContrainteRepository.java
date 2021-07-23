package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Contrainte;
@Repository
public interface ContrainteRepository extends CrudRepository<Contrainte,Long> {

}
