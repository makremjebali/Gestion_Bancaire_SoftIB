package tn.esprit.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Historique;
import tn.esprit.spring.repository.HistoriqueRepository;

@Service
public class HistoriqueService implements IHistoriqueService {
@Autowired
HistoriqueRepository historiquerep;
	@Override
	public List<Historique> retrieveAllHistoriques() {
		// TODO Auto-generated method stub
		return (List<Historique>)historiquerep.findAll();
	}

	@Override
	public Historique addHistorique(Historique u) {
		// TODO Auto-generated method stub
		return historiquerep.save(u);
	}

	@Override
	public void deleteHistorique(Long id) {
		historiquerep.deleteById(id);

	}

	@Override
	public Historique updateHistorique(Historique u) {
		// TODO Auto-generated method stub
		return historiquerep.save(u);
	}

	@Override
	public Historique retrieveHistorique(Long id) {
		// TODO Auto-generated method stub
		return historiquerep.findById(id).get();
	}

}
