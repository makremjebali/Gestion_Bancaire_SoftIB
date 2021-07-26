package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Banque;



public interface IBanqueService {
	public Banque addBanque(Banque u);
	public void deleteBanque(Long id);
	public Banque updateBanque(Banque u,Long id);
}
