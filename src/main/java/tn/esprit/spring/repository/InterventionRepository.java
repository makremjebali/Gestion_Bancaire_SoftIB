package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Intervention;



@Repository
public interface InterventionRepository extends CrudRepository<Intervention, Long>{

}
