package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Client;



public interface IClientService {
	public List<Client> retrieveAllClients();
	public Client addClient(Client c,Long IdUser);
	public void deleteClient(Long id);
	public Client updateClient(Client u,Long id);
	public Client retrieveClient(Long id);
}
