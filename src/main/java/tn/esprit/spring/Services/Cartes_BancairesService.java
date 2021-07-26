package tn.esprit.spring.Services;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Cartes_Bancaires;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteEpargne;
import tn.esprit.spring.repository.CarteBancaireRepository;
import tn.esprit.spring.repository.CompteRepository;

@Service
public class Cartes_BancairesService implements ICartes_BancairesService {

	@Autowired
	CompteRepository compterepository;
	@Autowired
	CarteBancaireRepository cartebancairerepository;
	@Override
	public Cartes_Bancaires DemanderuneCarteBancaires(String idCompte) {
		
		Compte cpte = compterepository.findById(idCompte).get();
		Cartes_Bancaires c = new Cartes_Bancaires();
		if (cpte instanceof CompteEpargne)
		{
			throw new RuntimeException("Compte not support demanderuneCarteBancaires ");
		}
		int randomNumero_carte = ThreadLocalRandom.current().nextInt(11111111, 99999999);
		c.setNumero_carte(randomNumero_carte);
		c.setDuree_de_validite("3 ans");
		int randomMot_passe = ThreadLocalRandom.current().nextInt(1111, 9999);
		c.setMot_passe(randomMot_passe);
		c.setCompte(cpte);
		
	return cartebancairerepository.save(c);
	}
	@Override
	public Cartes_Bancaires ModifierCarteBancaires(int numero_carte, int mot_passe) {
		// TODO Auto-generated method stub
		Cartes_Bancaires c =cartebancairerepository.findById(numero_carte).get();
		c.setMot_passe(mot_passe);
		cartebancairerepository.save(c);
		
		return c;
	}
	
	
}
