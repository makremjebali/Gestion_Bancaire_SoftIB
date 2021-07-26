package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Agence;



public interface IAgenceService {
	public List<Agence> retrieveAllAgences();
	public Agence addAgence(Agence u,Long IdBanque);
	public void deleteAgence(Long id);
	public Agence updateAgence(Agence u,Long id);
	public Agence retrieveAgence(Long id);
}
