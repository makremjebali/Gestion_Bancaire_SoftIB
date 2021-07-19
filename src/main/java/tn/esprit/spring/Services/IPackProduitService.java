package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.PackProduit;



public interface IPackProduitService {
	public List<PackProduit> retrieveAllPackProduits();
	public PackProduit addPackProduit(PackProduit u);
	public void deletePackProduit(Long id);
	public PackProduit updatePackProduit(PackProduit u);
	public PackProduit retrievePackProduit(Long id);
}
