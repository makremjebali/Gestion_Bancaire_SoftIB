package tn.esprit.spring.Services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.Entity.Client;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.Entity.Credit;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.ContrainteRepository;
import tn.esprit.spring.repository.CreditRepository;

@Service
public class CreditService implements ICreditService {

	@Autowired
	CompteRepository compteepository;
	@Autowired
	ContrainteRepository contrainterepository;
	@Autowired
	ContrainteService contrainteservice;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CreditRepository creditRepository;
	
	private static final Logger logger = LogManager.getLogger(CreditService.class);
	
	@Override
	public String GetTMMFromSitebct() {
		String TMM = "";
		Document doc = null;
		try {

			doc = Jsoup.connect("https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105").get();

		} catch (IOException e) {

			logger.error(e.getStackTrace());
			e.printStackTrace();
		}

		Elements repositories = doc.getElementsByClass("t-right");

		logger.info("INFO : +Element+ = " + repositories.get(41).text() + " ");
		TMM = repositories.get(41).text();
//
//		for (Element repository : repositories) {
//			logger.info("INFO : Element = " + repository.text());
//		}

		return TMM;
	}
	
	@Override
	public void demanderCredit(String CodeCompte, Long CodeClient ,Long idcontrainte) {
		Compte cpte = compteepository.findById(CodeCompte).get();
		// List<Contrainte> listContrainte =
		// contrainteservice.retrieveAllContrainte();
		Contrainte cc = contrainterepository.findById(idcontrainte).get();
		Client c = clientRepository.findById(CodeClient).get();
		Date d = new Date();
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyyMMdd");
		int d1 = Integer.parseInt(formatter.format(cpte.getClients().getDateNaissance()));
		int d2 = Integer.parseInt(formatter.format(d));
		int age = (d2 - d1) / 10000;
		if (cpte.getSolde() < cc.getMontant() && (age > cc.getAge())) {
			throw new RuntimeException("votre demander a ete refuse par contrainte de age ou bien solde");
		} else {

			Credit credit = new Credit();
			if (cc.getType_contrainte().equals("Crédit immobilier")) {
				credit.setDuree(84);
				credit.setMontant(70000F);
				double poursont = 5;
				//double TMM = Double.parseDouble(GetTMMFromSitebct());
				double TMM = Double.parseDouble("6.26000");			
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 84) * credit.getTaux());
				credit.setClient(c);
				credit.setType_credit(cc.getType_contrainte());
				creditRepository.save(credit);
			} else if(cc.getType_contrainte().equals("Crédit Véhicule")){
				
				credit.setDuree(100);
				credit.setMontant(50000F);
				double poursont = 5;
				//double TMM = Double.parseDouble(GetTMMFromSitebct());
				double TMM = Double.parseDouble("6.26000");	
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 100) * credit.getTaux());
				credit.setClient(c);
				credit.setType_credit(cc.getType_contrainte());
				creditRepository.save(credit);
			} else if (cc.getType_contrainte().equals("Crédit éspece")){
				credit.setDuree(150);
				credit.setMontant(100000F);
				double poursont = 5;
				//double TMM = Double.parseDouble(GetTMMFromSitebct());
				double TMM = Double.parseDouble("6.26000");	
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 150) * credit.getTaux());
				credit.setClient(c);
				credit.setType_credit(cc.getType_contrainte());
				creditRepository.save(credit);
			}
		}
		

	}
		
	@Override
	public void UpadtedemandeCredit(Long id, Credit c) {
		Credit credit=creditRepository.findById(id).get();
		credit.setMontant(c.getMontant());
		credit.setDuree(c.getDuree());
		credit.setTaux(c.getTaux());
		credit.setÉcheances(c.getÉcheances());
		credit.setType_credit(c.getType_credit());
		
		 creditRepository.save(credit);
		}
		
	

	@Override
	public void deletedemandeCredit(Long id) {
		Credit c = creditRepository.findById(id).get();
		
		c.setClient(null);
		creditRepository.save(c);
		creditRepository.deleteById(id);
		
	}

	@Override
	public Credit AfficheCreditbyId(long id) {
		
		return creditRepository.findById(id).get();
	}

	@Override
	public List<Credit> AfficheAllCredit() {
	
		return (List<Credit>)  creditRepository.findAll();
	}
	
	
	
}
