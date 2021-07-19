package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Banque;



public interface IBanqueService {
	public List<Banque> retrieveAllBanques();
	public Banque addBanque(Banque u);
	public void deleteBanque(Long id);
	public Banque updateBanque(Banque u);
	public Banque retrieveBanque(Long id);
}
