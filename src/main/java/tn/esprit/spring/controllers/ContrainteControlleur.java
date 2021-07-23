package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.Services.IContrainteService;


@RestController
public class ContrainteControlleur {
	
	@Autowired
    IContrainteService icontrainteService;

	@PostMapping(value= "/addContrainte/{Idc}")
	@ResponseBody
	public void AddContrainte(@RequestBody Contrainte c,@PathVariable("Idc") long idcontrainte) {
		icontrainteService.AddContrainte(c, idcontrainte);
	}
	@PutMapping(value="/ModifierContrainte/{Idc}")
	public Contrainte UpdateContrainte(@PathVariable ("Idc") long idcontrainte) {
		return icontrainteService.UpdateContrainte(idcontrainte);
	}
	@DeleteMapping("/deleteContrainte/{idc}")
	public void DeleteContrainte(@PathVariable ("Idc")  long idcontrainte) {
		icontrainteService.DeleteContrainte(idcontrainte);
	}
	


}
