package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Services.IFactureService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class FactureController {

	@Autowired
	IFactureService iFactureService;

	@GetMapping(value="/download/{id}")
	@ResponseBody
	public ResponseEntity<Object> GetFactureById(@PathVariable("id") Long id) {
		return iFactureService.GetFactureById(id);
	}



	
	
	
}
