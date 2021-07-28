package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.Services.IContrainteService;


@RestController
@RequestMapping("/api/test")
public class ContrainteControlleur {
	
	@Autowired
    IContrainteService icontrainteService;

	@PostMapping("/addContrainte")
	@ResponseBody
	public void AddContrainte(@RequestBody Contrainte c) {
		icontrainteService.AddContrainte(c);
	}
	@PutMapping(value="/ModifierContrainte/{Idc}")
	@ResponseBody
	public Contrainte UpdateContrainte(@RequestBody Contrainte c, @PathVariable ("Idc") long idcontrainte) {
		return icontrainteService.UpdateContrainte(c,idcontrainte);
	}
	@DeleteMapping("/deleteContrainte/{idc}")
	public void DeleteContrainte(@PathVariable ("idc")  long idcontrainte) {
		icontrainteService.DeleteContrainte(idcontrainte);
	}
	


}
