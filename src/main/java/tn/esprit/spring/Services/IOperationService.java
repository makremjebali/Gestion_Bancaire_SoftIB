package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.Entity.Operation;

public interface IOperationService {
	
	
	public List<Operation> getoperation(String codecompte);
	
	public double  GetMoyenneDesTransactions(Date datejour);
}
