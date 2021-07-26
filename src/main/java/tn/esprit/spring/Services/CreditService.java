package tn.esprit.spring.Services;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Contrainte;
import tn.esprit.spring.Entity.Credit;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.ContrainteRepository;
import tn.esprit.spring.repository.CreditRepository;

@Service
public class CreditService implements ICreditService {
	@Autowired
	CreditRepository creditRepository;
	@Autowired
	CompteRepository compteepository;
	@Autowired
	ContrainteRepository contrainterepository;
	@Autowired
	ContrainteService contrainteservice;


	private static final Logger logger = LogManager.getLogger(CreditService.class);

	@Test
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

	/*
	 * final String url =
	 * "https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105";
	 * try { final Document document =Jsoup.connect(url).get();
	 * //l.info(document.outerHtml()); for (Element rwo :
	 * document.select("div.bct-table-fixed tr")) { if
	 * (rwo.select("td.t-right:nth-of-type(7)").text().equals("")){ continue; }
	 * else { String ticker = rwo.select("td.t-right:nth-of-type(7)").text(); if
	 * (ticker.equals("6,26000")) { TMM=ticker; }
	 * 
	 * } } }catch(Exception ex){ex.printStackTrace();}
	 */

	@Override
	public void demanderCredit(String CodeCompte, Long CodeClient, Long idCredit, Long idcontrainte,
			String typecredit) {

		Compte cpte = compteepository.findById(CodeCompte).get();
		// List<Contrainte> listContrainte =
		// contrainteservice.retrieveAllContrainte();
		Contrainte cc = contrainterepository.findById(idcontrainte).get();
		Date d = new Date();
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		int d1 = Integer.parseInt(formatter.format(cpte.getClients().getDateNaissance()));
		int d2 = Integer.parseInt(formatter.format(d));
		int age = (d2 - d1) / 10000;
		if (cpte.getSolde() < cc.getMontant() && (age > cc.getAge())) {
			throw new RuntimeException("votre demander a ete refuse par contrainte de age ou bien solde");
		} else {

			Credit credit = creditRepository.findById(idCredit).get();
			if (typecredit.equals("Crédit immobilier")) {
				credit.setDuree(84);
				credit.setMontant(70000F);
				double poursont = 5;
				double TMM = Double.parseDouble(GetTMMFromSitebct());
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 84) * credit.getTaux());
			} else if(typecredit.equals("Crédit Véhicule")){
				
				credit.setDuree(100);
				credit.setMontant(50000F);
				double poursont = 5;
				double TMM = Double.parseDouble(GetTMMFromSitebct());
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 100) * credit.getTaux());
			} else if (typecredit.equals("Crédit éspece")){

				credit.setDuree(150);
				credit.setMontant(100000F);
				double poursont = 5;
				double TMM = Double.parseDouble(GetTMMFromSitebct());
				credit.setTaux(TMM + poursont);
				credit.setÉcheances((credit.getMontant() / 150) * credit.getTaux());
			}
		}

	}
}
