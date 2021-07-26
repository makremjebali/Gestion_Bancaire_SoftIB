package tn.esprit.spring.Services;


import tn.esprit.spring.Entity.Cartes_Bancaires;

public interface ICartes_BancairesService {
	public Cartes_Bancaires DemanderuneCarteBancaires (String idCompte); 
	public Cartes_Bancaires ModifierCarteBancaires(int numero_carte,int mot_passe ) ;
}
