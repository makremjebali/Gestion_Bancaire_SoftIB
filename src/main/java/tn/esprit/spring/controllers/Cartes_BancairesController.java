package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Cartes_Bancaires;
import tn.esprit.spring.Services.ICartes_BancairesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class Cartes_BancairesController {
	@Autowired
	ICartes_BancairesService iCartes_BancairesService;

	@PostMapping(value= "/DemanderuneCarteBancaires/{IdC}")
	@ResponseBody
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Cartes_Bancaires DemanderuneCarteBancaires(@PathVariable("IdC") String idCompte) {
		return iCartes_BancairesService.DemanderuneCarteBancaires(idCompte);
	}
	
	@PostMapping(value= "/ModifierCarteBancaires/{NumC}/{motpass}")
	@ResponseBody
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Cartes_Bancaires ModifierCarteBancaires(@PathVariable("NumC")int numero_carte,@PathVariable("motpass") int mot_passe) {
		return iCartes_BancairesService.ModifierCarteBancaires(numero_carte, mot_passe);
	}
	
	
	

}
