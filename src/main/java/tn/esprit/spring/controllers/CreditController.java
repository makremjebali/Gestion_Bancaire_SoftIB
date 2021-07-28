package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Credit;
import tn.esprit.spring.Services.CreditService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class CreditController {

	@Autowired
	CreditService creditService;

	@PostMapping(value= "/demanderCredit/{CodeCompte}/{CodeClient}/{idcontrainte}")
	@ResponseBody
	public void demanderCredit(@PathVariable("CodeCompte")String CodeCompte,@PathVariable("CodeClient") Long CodeClient,
			@PathVariable("idcontrainte") Long idcontrainte,
			String typecredit) {
		creditService.demanderCredit(CodeCompte, CodeClient,idcontrainte);
	}


	@PutMapping(value="/UpadtedemandeCredit/{idC}")
	public void UpadtedemandeCredit(@PathVariable("idC") Long id, @RequestBody Credit c) {
		creditService.UpadtedemandeCredit(id, c);
	}

	@GetMapping(value ="/AfficheCreditbyId/{idc}")
	@ResponseBody
	public Credit AfficheCreditbyId(@PathVariable("idc") long id) {
		return creditService.AfficheCreditbyId(id);
	}
	@GetMapping("/AfficheAllCredit")
	@ResponseBody
	public List<Credit> AfficheAllCredit() {
		return creditService.AfficheAllCredit();
	}

	@DeleteMapping(value="/deletedemandeCredit/{idC}")
	public void deletedemandeCredit(@PathVariable("idC") Long id) {
		creditService.deletedemandeCredit(id);
	}


	
	
	
	
}
