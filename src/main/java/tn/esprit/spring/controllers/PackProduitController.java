package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.PackProduit;
import tn.esprit.spring.Services.IPackProduitService;

@RestController
@RequestMapping("/api/auth")
public class PackProduitController {

	@Autowired
	IPackProduitService iPackProduitService;
	
	@GetMapping("/retrieveAllPackProduits")
	@ResponseBody
	public List<PackProduit> retrieveAllPackProduits() {
		return iPackProduitService.retrieveAllPackProduits();
	}

	@PostMapping(value= "/addPackProduit/{IdB}")
	@ResponseBody
	public PackProduit addPackProduit(@RequestBody PackProduit p,@PathVariable("IdB") Long IdBanque) {
		return iPackProduitService.addPackProduit(p, IdBanque);
	}

	@DeleteMapping("/deletePackProduit/{idp}")
	public void deletePackProduit(@PathVariable("idp") Long id) {
		iPackProduitService.deletePackProduit(id);
	}

	public PackProduit updatePackProduit(PackProduit u) {
		return iPackProduitService.updatePackProduit(u);
	}
	
	
	
}
