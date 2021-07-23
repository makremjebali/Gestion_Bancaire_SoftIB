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

	public CompteCourant(String compte_identifiant, Date date_ouverture, double solde, double decouvert) {
		super(compte_identifiant, date_ouverture, solde);
		this.decouvert = decouvert;
	}


	public CompteCourant(String compte_identifiant, Date date_ouverture, double solde, Agence agence,
			Cartes_Bancaires carteBancaire, Client clients, double decouvert) {
		super(compte_identifiant, date_ouverture, solde, agence, carteBancaire, clients);
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
		return "CompteCourant [decouvert=" + decouvert + ", getCompte_identifiant()=" + getCompte_identifiant()
				+ ", getDate_ouverture()=" + getDate_ouverture() + ", getSolde()=" + getSolde() + ", getAgence()="
				+ getAgence() + ", getCarteBancaire()=" + getCarteBancaire() + ", getClients()=" + getClients()
				+ ", getOperations()=" + getOperations() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}



}
