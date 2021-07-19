package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.repository.ClientRepository;


@Service
public class ClientService implements IClientService {
@Autowired
ClientRepository clientrep;
	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		return (List<Client>)clientrep.findAll();
	}

	@Override
	public Client addClient(Client u) {
		// TODO Auto-generated method stub
		return clientrep.save(u);
	}

	@Override
	public void deleteClient(Long id) {
		clientrep.deleteById(id);

	}

	@Override
	public Client updateClient(Client u) {
		// TODO Auto-generated method stub
		return clientrep.save(u);
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return clientrep.findById(id).get();
	}

}
