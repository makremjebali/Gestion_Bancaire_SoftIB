package tn.esprit.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.Entity.Agence;
import tn.esprit.spring.Entity.Banque;
import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.CompteCourant;
import tn.esprit.spring.Entity.CompteEpargne;
import tn.esprit.spring.Entity.Operation;
import tn.esprit.spring.Services.IAgenceService;
import tn.esprit.spring.Services.IBanqueService;
import tn.esprit.spring.Services.IClientService;
import tn.esprit.spring.Services.ICompteService;
import tn.esprit.spring.Services.ICreditService;
import tn.esprit.spring.Services.IOperationService;
import tn.esprit.spring.Services.IStatistiquesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityJwtApplicationTests {
	private static final Logger l = LogManager.getLogger(SpringBootSecurityJwtApplicationTests.class);
	@Autowired
	ICompteService icompteService;
	@Autowired
	IStatistiquesService istatistiquesService;
	@Autowired
	IOperationService ioperationService;
	@Autowired 
	IBanqueService ibanqueService;
	@Autowired
	IClientService iclientService;
	@Autowired
	IAgenceService iagenceservice;
	@Autowired
	ICreditService icreditservice;
	@Test
	public void contextLoads() {
		CompteCourant CC = new CompteCourant("c6", new Date(), 5000, 2540);
		CompteEpargne CE = new CompteEpargne("c5", new Date(), 9000, 5000);
		//icompteService.addCompte(CC);
		//icompteService.addCompte(CE);
		//l.info(icompteService.consulterCompte("c1"));
		//icompteService.retrait("c6", 2000);
		//icompteService.versement("c3", 2000);
		//icompteService.retrait("c2", 3000);
		//icompteService.virement("c3", "c1", 575);
		//l.info(icompteService.listCompte());
		/*List<Compte> list = new ArrayList<Compte>();list.add(icompteService.consulterCompte("c1"));
		
		for (Compte c:list)
		{
			l.info(c);
		}*/
		
		
		//l.info(" NumerosComptePlusGrandSolde  "+istatistiquesService.GetNumerosComptePlusGrandSoldeASC());
		//l.info(" NumerosComptePlusPetitSolde  "+istatistiquesService.GetNumerosComptePlusPetitSoldeASC());
	
		//l.info(" GetMoyenneDesSalaires  "+istatistiquesService.GetMoyenneDesSalaires());
		//l.info(" GetNombreDecompteParType  "+istatistiquesService.GetNombreDecompteParType());
		//l.info(ioperationService.retrieveOperation("c1"));
		//icompteService.listoperation("c1");
		
		//icompteService.listoperation("c1");
		
		//for (Operation c:icompteService.listoperation("c1"))
		//{
			//l.info(c);
		//}
		Banque ban = new Banque("BNA", "BNA@gmail.com", "71526987", "71452369", "beja");
		
		Date d = new Date();
		
		//l.info(ioperationService.GetMoyenneDesTransactions(new Date()));
		//l.info(istatistiquesService.GetMoyenneDesSalaires());
		//l.info(ioperationService.GetMoyenneDesTransactions(d));
		
	}
	
	@Test
	public void testwebscrabling() {
/*		String TMM="";
		final String url ="https://www.bct.gov.tn/bct/siteprod/tableau_statistique_a.jsp?params=PL203105";
		try {
			final Document document =Jsoup.connect(url).get();
			//l.info(document.outerHtml());
			for (Element rwo : document.select("div.bct-table-fixed tr"))
			{
				if (rwo.select("td.t-right:nth-of-type(7)").text().equals("")){
					continue;
				}
				else {
					String ticker = rwo.select("td.t-right:nth-of-type(7)").text();
						if (ticker.equals("6,26000"))
						{
							TMM=ticker;
						}
					System.out.println(TMM);
					System.out.println(ticker);
				}
				
			
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
		
		//l.info(istatistiquesService.GetNombreDecompteParType());
		//l.info(istatistiquesService.GetNumerosComptePlusGrandSoldeASC());
		//l.info(istatistiquesService.GetNumerosComptePlusPetitSoldeASC());
		//l.info(istatistiquesService.CalculeTMM());
		//l.info(iagenceservice.retrieveAllAgences());
		//icreditservice.demanderCredit("c1", 4, idCredit, idcontrainte, typecredit);
	}

}
