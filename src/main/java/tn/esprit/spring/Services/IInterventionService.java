package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Intervention;



public interface IInterventionService {
	public List<Intervention> retrieveAllInterventions();
	public Intervention addIntervention(Intervention u);
	public void deleteIntervention(Long id);
	public Intervention updateIntervention(Intervention u);
	public Intervention retrieveIntervention(Long id);
}
