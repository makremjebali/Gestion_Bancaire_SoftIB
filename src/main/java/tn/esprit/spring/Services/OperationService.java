package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Operation;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.OperationRepository;

@Service
public class OperationService implements IOperationService {
	@Autowired
	OperationRepository operationrep;
	@Autowired
	CompteRepository compteRepository;
	

	@Override
	public double GetMoyenneDesTransactions(Date datejour) {
		
		return operationrep.GetMoyenneDesTransactions(datejour);
	}


	@Override
	public List<Operation> getoperation(String codecompte) {
		// TODO Auto-generated method stub
		
		List<Operation> ops= operationrep.listoperation(codecompte);
	
		
		return ops;
	}

}
