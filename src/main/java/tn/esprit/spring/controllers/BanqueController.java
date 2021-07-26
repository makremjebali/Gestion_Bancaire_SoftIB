package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.Services.IBanqueService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class BanqueController {
	@Autowired
	IBanqueService iBanqueService;

	@PostMapping( "/addBanque")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public Banque addBanque(@RequestBody Banque u) {
		return iBanqueService.addBanque(u);
	}

	
	
	
}
