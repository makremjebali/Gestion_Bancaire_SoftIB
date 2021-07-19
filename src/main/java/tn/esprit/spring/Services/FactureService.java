package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Facture;
import tn.esprit.spring.repository.factureRepository;

@Service
public class FactureService implements IFactureService {
@Autowired
factureRepository facturerep;
	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		return (List<Facture>)facturerep.findAll();
	}

	@Override
	public Facture addFacture(Facture u) {
		// TODO Auto-generated method stub
		return facturerep.save(u);
	}

	@Override
	public void deleteFacture(Long id) {
		facturerep.deleteById(id);

	}

	@Override
	public Facture updateFacture(Facture u) {
		// TODO Auto-generated method stub
		return facturerep.save(u);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return facturerep.findById(id).get();
	}

}
