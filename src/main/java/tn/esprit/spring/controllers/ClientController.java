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

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Services.IClientService;

@RestController
@RequestMapping("/api/auth")
public class ClientController {

	@Autowired
	IClientService iClientService;
	
	@PostMapping( "/addClient/{IdU}")
	@ResponseBody
	public Client addClient(@RequestBody Client c,@PathVariable("IdU")Long IdUser)
	{
		return iClientService.addClient(c, IdUser);
	}

	@GetMapping("/retrieveAllClients")
	@ResponseBody
	public List<Client> retrieveAllClients() {
	
	return iClientService.retrieveAllClients();
	}
	
}
