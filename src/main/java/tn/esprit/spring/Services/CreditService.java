package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Credit;
import tn.esprit.spring.repository.CreditRepository;


@Service
public class CreditService implements ICreditService {
@Autowired
CreditRepository creditrep;
	@Override
	public List<Credit> retrieveAllCredits() {
		// TODO Auto-generated method stub
		return (List<Credit>)creditrep.findAll();
	}

	@Override
	public Credit addCredit(Credit u) {
		// TODO Auto-generated method stub
		return creditrep.save(u);
	}

	@Override
	public void deleteCredit(Long id) {
		creditrep.deleteById(id);

	}

	@Override
	public Credit updateCredit(Credit u) {
		// TODO Auto-generated method stub
		return creditrep.save(u);
	}

	@Override
	public Credit retrieveCredit(Long id) {
		// TODO Auto-generated method stub
		return creditrep.findById(id).get();
	}

}
