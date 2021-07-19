package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Historique;

@Repository
public interface HistoriqueRepository extends CrudRepository<Historique, Long>{

}
