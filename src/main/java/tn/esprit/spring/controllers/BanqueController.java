package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.Services.IBanqueService;

@RestController
@RequestMapping("/api/auth")
public class BanqueController {
	@Autowired
	IBanqueService iBanqueService;

	@PostMapping( "/addBanque")
	@ResponseBody
	public Banque addBanque(Banque u) {
		return iBanqueService.addBanque(u);
	}

	
	
	
}
