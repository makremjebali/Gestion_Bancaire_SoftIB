package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.repository.BanqueRepository;


@Service
public class BanqueService implements IBanqueService {
@Autowired
BanqueRepository banquerep;

	@Override
	public Banque addBanque(Banque u) {
		return banquerep.save(u);
	}

	@Override
	public void deleteBanque(Long id) {
		banquerep.deleteById(id);

	}

	@Override
	public Banque updateBanque(Banque u) {
		return banquerep.save(u);
	}


}
