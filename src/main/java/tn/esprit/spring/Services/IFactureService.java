package tn.esprit.spring.Services;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.Entity.Facture;


public interface IFactureService {
	
	public ResponseEntity<Object> GetFactureById(Long id);
}
