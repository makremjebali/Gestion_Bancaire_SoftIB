package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

private static final Logger l = LogManager.getLogger(AgenceService.class);
	@Override
	public List<Agence> retrieveAllAgences() {
		for (Agence a:agencerep.findAll())
		{
			l.info(a);
		}
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
