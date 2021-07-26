package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class ClientService implements IClientService {
	@Autowired
	ClientRepository clientrep;
	@Autowired
	UserRepository userrepository;
	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		return (List<Client>)clientrep.findAll();
	}

	@Override
	public Client addClient(Client c,Long IdUser) {
		// TODO Auto-generated method stub
		User u =  userrepository.findById(IdUser).get();
		c.setUser(u);
		return clientrep.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		Client client =clientrep.findById(id).get();
		client.setUser(null);
		clientrep.save(client);
		clientrep.deleteById(id);

	}

	@Override
	public Client updateClient(Client u,Long id) {
		// TODO Auto-generated method stub
		Client client =clientrep.findById(id).get();
		return clientrep.save(u);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return clientrep.findById(id).get();
	}

}
