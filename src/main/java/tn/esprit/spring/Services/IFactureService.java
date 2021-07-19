package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Facture;


public interface IFactureService {
	public List<Facture> retrieveAllFactures();
	public Facture addFacture(Facture u);
	public void deleteFacture(Long id);
	public Facture updateFacture(Facture u);
	public Facture retrieveFacture(Long id);
}
