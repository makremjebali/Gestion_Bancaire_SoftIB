package tn.esprit.spring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.Services.IAgenceService;

@RestController
@RequestMapping("/api/auth")
public class AgenceController {
	@Autowired
	IAgenceService iAgenceService;
	
	@PostMapping(value= "/addAgence/{IdB}")
	@ResponseBody
	public Agence addAgence(@RequestBody Agence a,@PathVariable ("IdB") Long IdBanque)
	{
		return iAgenceService.addAgence(a, IdBanque);
	}

	@GetMapping("/retrieveAllAgence")
	@ResponseBody
	public List<Agence> retrieveAllAgence() {
	
	return iAgenceService.retrieveAllAgences();
	}
}
