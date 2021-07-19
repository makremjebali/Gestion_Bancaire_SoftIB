package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entity.Historique;




public interface IHistoriqueService {
	public List<Historique> retrieveAllHistoriques();
	public Historique addHistorique(Historique u);
	public void deleteHistorique(Long id);
	public Historique updateHistorique(Historique u);
	public Historique retrieveHistorique(Long id);
}
