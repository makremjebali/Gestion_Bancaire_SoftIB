package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.Entity.Operation;
import tn.esprit.spring.Services.CompteService;
import tn.esprit.spring.Services.ICompteService;
import tn.esprit.spring.Services.IOperationService;

@RestController
@RequestMapping("/api/auth")
public class TransactionsController {
	@Autowired
	ICompteService iCompteService;
	@Autowired
	IOperationService iOperationService;
	
	private static final Logger l = LogManager.getLogger(CompteService.class);
	
	@GetMapping(value="/getoperation/{codec}")
	@ResponseBody
	public List<Operation> getoperation(@PathVariable("codec") String codecompte) {
		return iOperationService.getoperation(codecompte);
	}
	@GetMapping(value="/consulterCompte/{codec}")
	@ResponseBody
	public void consulterCompte(@PathVariable("codec")String codecompte)
	{
		List<Compte> list = new ArrayList<>();
		list.add(iCompteService.consulterCompte(codecompte));
		for (Compte c:list)
		{
			l.info(c);
		}
	}
	@GetMapping(value="/GetCompte/{codec}")
	@ResponseBody
	public Compte GetCompte(@PathVariable ("codec") String code_cpte){
	return iCompteService.GetCompte(code_cpte);
}
	
	//{"compte_identifiant":"c9","solde":"250000","type_cpte":"CC","decouvert":"3000"}
	//{"compte_identifiant":"c7","solde":"60000","type_cpte":"CE","taux":"6000"}
	@PostMapping(value= "/addCompte/{idA}/{idC}")
	public Compte addCompte(@RequestBody Compte c,@PathVariable("idA") Long idAgence,@PathVariable("idC") Long code_client)
	{
		iCompteService.addCompte(c, idAgence, code_client);
		return c;
	}
	
	@PutMapping(value="/retrait/{codecompte}/{montant}")
	public void retrait(@PathVariable("codecompte") String codecompte,@PathVariable("montant") double montant){
		iCompteService.retrait(codecompte, montant);
	}
	
	@PutMapping(value="/versement/{codecompte}/{montant}")
	public void versement(@PathVariable("codecompte") String codecompte,@PathVariable("montant") double montant){
		iCompteService.versement(codecompte, montant);
	}
	@PutMapping(value="/virement/{codecompte1}/{codecompte2}/{montant}")
	public void virement(@PathVariable("codecompte1") String codecompte1,@PathVariable("codecompte2") String codecompte2
			,@PathVariable("montant") double montant){
		iCompteService.virement(codecompte1, codecompte2, montant);
	}
}
