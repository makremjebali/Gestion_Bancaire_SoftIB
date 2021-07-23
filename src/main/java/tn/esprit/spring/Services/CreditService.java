package tn.esprit.spring.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Compte;
import tn.esprit.spring.Entity.Credit;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.CreditRepository;


@Service
public class CreditService implements ICreditService {
	@Autowired
	CreditRepository creditRepository;
	@Autowired
	CompteRepository compteepository;
	@Override
	public void demanderCredit(String CodeCompte, Long CodeClient,Long idCredit) {
		
		/*Compte cpte = compteepository.findById(CodeCompte).get();
		Contrainte cc = conre.findAll();
		Date d = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		int d1 = Integer.parseInt(formatter.format(cpte.getClients().getDateNaissance()));
	    int d2 = Integer.parseInt(formatter.format(d));
	    int age = (d2 - d1) / 10000;
		if (cpte.getSolde()<cc.getmontant()&&(age>cc.getAge))
		{
			l.into("votre demander a ete refuse par contrainte de age ou bien solde");
		}
		else
		{
			
		Credit credit = creditRepository.findById(idCredit).get();
		if (credit.getType_credit().equals("sayara cha3biya"))
		{
			credit.setDuree(84);
			credit.setMontant(50000F);
			double TMM,poursont=5;
			credit.settaux(TMM+poursont);
			credit.setecheances((credit.getMontant()/84)*credit.settaux);
			
		}
		}
			
		}*/

}
	
}