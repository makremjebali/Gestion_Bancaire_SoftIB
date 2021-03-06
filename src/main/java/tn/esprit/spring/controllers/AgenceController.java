package tn.esprit.spring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.Services.IAgenceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AgenceController {
	@Autowired
	IAgenceService iAgenceService;
	
	@PostMapping(value= "/addAgence/{IdB}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public Agence addAgence(@RequestBody Agence a,@PathVariable ("IdB") Long IdBanque)
	{
		return iAgenceService.addAgence(a, IdBanque);
	}

	@GetMapping("/retrieveAllAgence")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public List<Agence> retrieveAllAgences() {
		return iAgenceService.retrieveAllAgences();
	}

	@DeleteMapping("/deleteAgence/{idA}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAgence(@PathVariable("idA") Long id) {
		iAgenceService.deleteAgence(id);
	}
	@PutMapping(value="/updateAgence/{idA}")
	@PreAuthorize("hasRole('ADMIN')")
	public Agence updateAgence(@RequestBody Agence u,@PathVariable ("idA") Long id) {
		return iAgenceService.updateAgence(u, id);
	}
	@GetMapping(value="/retrieveAgence/{idA}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public Agence retrieveAgence(@PathVariable("idA") Long id) {
		return iAgenceService.retrieveAgence(id);
	}
	
	
}
