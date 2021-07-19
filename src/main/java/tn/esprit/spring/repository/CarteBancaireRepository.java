package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Cartes_Bancaires;


@Repository
public interface CarteBancaireRepository extends CrudRepository<Cartes_Bancaires, Integer>{

}
