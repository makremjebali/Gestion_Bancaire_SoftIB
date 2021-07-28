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

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Services.IClientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class ClientController {

	@Autowired
	IClientService iClientService;
	
	@PostMapping( "/addClient/{IdU}")
	@ResponseBody
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Client addClient(@RequestBody Client c,@PathVariable("IdU")Long IdUser)
	{
		return iClientService.addClient(c, IdUser);
	}

	@GetMapping("/retrieveAllClients")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public List<Client> retrieveAllClients() {
	
	return iClientService.retrieveAllClients();
	}

	@DeleteMapping("/deleteClient/{idA}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteClient(@PathVariable("idA")Long id) {
		iClientService.deleteClient(id);
	}

	@PutMapping(value="/updateClient/{idA}")
	public Client updateClient(@PathVariable("idA")Long id) {
		return iClientService.updateClient(id);
	}
    @PutMapping(value="/retrieveClient/{idA}")
	public Client retrieveClient(@PathVariable("idA")Long id) {
		return iClientService.retrieveClient(id);
	}
	
}
