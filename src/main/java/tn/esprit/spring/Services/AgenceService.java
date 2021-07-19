package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.repository.AgenceRepository;

@Service
public class AgenceService implements IAgenceService {
@Autowired
AgenceRepository agencerep;
	@Override
	public List<Agence> retrieveAllAgences() {
		return (List<Agence>)agencerep.findAll();
	}

	@Override
	public Agence addAgence(Agence u) {
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
