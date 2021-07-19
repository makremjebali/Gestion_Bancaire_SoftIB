package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte implements Serializable {

	private double decouvert;



	public CompteCourant(String compte_identifiant, String type_cpte, Date date_ouverture, double solde, Agence agence,
			Cartes_Bancaires carteBancaire, Client clients, List<Operation> operations, double decouvert) {
		super(compte_identifiant, type_cpte, date_ouverture, solde, agence, carteBancaire, clients, operations);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}





	
}
