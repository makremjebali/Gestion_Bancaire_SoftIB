package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation implements Serializable {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date_opertaion, double montant, Compte compte, Historique historique) {
		super(date_opertaion, montant, compte, historique);
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date_opertaion, double montant, Compte compte) {
		super(date_opertaion, montant, compte);
		// TODO Auto-generated constructor stub
	}


	




}
