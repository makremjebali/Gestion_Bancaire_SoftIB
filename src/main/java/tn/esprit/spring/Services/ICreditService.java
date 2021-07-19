package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Credit;



public interface ICreditService {
	public List<Credit> retrieveAllCredits();
	public Credit addCredit(Credit u);
	public void deleteCredit(Long id);
	public Credit updateCredit(Credit u);
	public Credit retrieveCredit(Long id);
}
