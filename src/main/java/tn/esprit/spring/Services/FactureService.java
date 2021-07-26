package tn.esprit.spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.repository.factureRepository;

@Service
public class FactureService implements IFactureService {
@Autowired
factureRepository facturerep;

@Override
public Facture GetFactureById(Long id) {
	Facture f = facturerep.findById(id).get();
	
	return f;
}
	
}
