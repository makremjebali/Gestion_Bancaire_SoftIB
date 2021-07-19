package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Operation;

public interface IOperationService {
	public List<Operation> retrieveAllOperations();
	public Operation addOperation(Operation o);
	public void deleteOperation(Long id);
	public Operation updateOperation(Operation o);
	public Operation retrieveOperation(Long id);
}
