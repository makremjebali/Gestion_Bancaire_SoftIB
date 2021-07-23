package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte implements Serializable {
	
private double taux;

public CompteEpargne() {
	super();
	// TODO Auto-generated constructor stub
}


public CompteEpargne(String compte_identifiant, Date date_ouverture, double solde, double taux) {
	super(compte_identifiant, date_ouverture, solde);
	this.taux = taux;
}


public CompteEpargne(String compte_identifiant, Date date_ouverture, double solde, Agence agence,
		Cartes_Bancaires carteBancaire, Client clients, List<Operation> operations, double taux) {
	super(compte_identifiant, date_ouverture, solde, agence, carteBancaire, clients, operations);
	this.taux = taux;
}






public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}

@Override
public String toString() {
	return "CompteEpargne [taux=" + taux + "]";
}




}
