package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.BanqueRepository;

@Service
public class AgenceService implements IAgenceService {
@Autowired
AgenceRepository agencerep;
@Autowired
BanqueRepository banquerepository;
	@Override
	public List<Agence> retrieveAllAgences() {
		return (List<Agence>)agencerep.findAll();
	}

	@Override
	public Agence addAgence(Agence u,Long IdBanque) {
		Banque b = banquerepository.findById(IdBanque).get();
		u.setBanque(b);
		return agencerep.save(u);
	}

	@Override
	public void deleteAgence(Long id) {
		agencerep.deleteById(id);

	}

	@Override
	public Agence updateAgence(Agence u) {
		return agencerep.save(u);
	}

	@Override
	public Agence retrieveAgence(Long id) {
		return agencerep.findById(id).get();
	}

}
