package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.Entity.PackProduit;
import tn.esprit.spring.repository.BanqueRepository;
import tn.esprit.spring.repository.PackProduitRepository;


@Service
public class PackProduitService implements IPackProduitService {
@Autowired
PackProduitRepository packrep;
@Autowired
BanqueRepository banquerepository;
	@Override
	public List<PackProduit> retrieveAllPackProduits() {
		// TODO Auto-generated method stub
		return ( List<PackProduit> )packrep.findAll();
	}

	@Override
	public PackProduit addPackProduit(PackProduit p,Long IdBanque) {
		// TODO Auto-generated method stub
		Banque b = banquerepository.findById(IdBanque).get();
		p.setBanque(b);
		return packrep.save(p);
	}

	@Override
	public void deletePackProduit(Long id) {
		// TODO Auto-generated method stub
		PackProduit p = packrep.findById(id).get();
		p.setBanque(null);
		packrep.save(p);
		packrep.deleteById(id);
	}

	@Override
	public PackProduit updatePackProduit(PackProduit u) {
		// TODO Auto-generated method stub
		return packrep.save(u);
	}

	@Override
	public PackProduit retrievePackProduit(Long id) {
		// TODO Auto-generated method stub
		return packrep.findById(id).get();
	}

}
