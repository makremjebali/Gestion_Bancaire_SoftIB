package tn.esprit.spring.Services;

import tn.esprit.spring.Entity.Facture;


public interface IFactureService {
	
	public Facture GetFactureById(Long id);
}
