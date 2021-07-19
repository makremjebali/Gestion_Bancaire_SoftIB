package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation implements Serializable {

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date date_opertaion, double montant, Compte compte) {
		super(date_opertaion, montant, compte);
		// TODO Auto-generated constructor stub
	}



	

}
