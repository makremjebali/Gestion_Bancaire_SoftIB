package tn.esprit.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import tn.esprit.spring.Services.IBanqueService;
import tn.esprit.spring.Services.ICompteService;
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
		
		l.info(ioperationService.GetMoyenneDesTransactions(new Date()));
	}

}
