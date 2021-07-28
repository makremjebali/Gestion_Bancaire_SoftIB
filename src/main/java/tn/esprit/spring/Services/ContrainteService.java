package tn.esprit.spring.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.repository.ContrainteRepository;
@Service
public class ContrainteService implements IContrainteService {
	
	@Autowired
    ContrainteRepository contrainterepository;
	
	private static final Logger l = LogManager.getLogger(Contrainte.class);
	
	public void AddContrainte(Contrainte c) {
	
	if(c!=null){
		
		l.info("Contrainte existe déja");
		
	}
	contrainterepository.save(c) ;
		
	}

	public Contrainte UpdateContrainte(Contrainte c,long idcontrainte) {
		c.setIdcontrainte(idcontrainte);
		
		return contrainterepository.save(c);
		
	}

	public void DeleteContrainte(long idcontrainte) {
		Contrainte con=contrainterepository.findById(idcontrainte).get();
		contrainterepository.delete(con);
		
	}

	@Override
	public List<Contrainte> retrieveAllContrainte() {
		// TODO Auto-generated method stub
		return (List<Contrainte>)contrainterepository.findAll();
	}

}
