package tn.esprit.spring.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.SpringBootSecurityJwtApplicationTests;
import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.ContrainteRepository;
@Service
public class ContrainteService implements IContrainteService {
	@Autowired
    ContrainteRepository contrainterepository;
	private static final Logger l = LogManager.getLogger(Contrainte.class);
	
	public void AddContrainte(Contrainte c, long idcontrainte) {
	Contrainte con=contrainterepository.findById(idcontrainte).get();
	if(con!=null){
		
		l.info("Contrainte existe déja");
		
	}
	contrainterepository.save(c) ;
		
	}

	public Contrainte UpdateContrainte(long idcontrainte) {
		Contrainte con=contrainterepository.findById(idcontrainte).get();
		return contrainterepository.save(con);
		
	}

	public void DeleteContrainte(long idcontrainte) {
		Contrainte con=contrainterepository.findById(idcontrainte).get();
		contrainterepository.delete(con);
		
	}

}
