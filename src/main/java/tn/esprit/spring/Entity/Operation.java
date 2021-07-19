package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("OP")
@DiscriminatorColumn(name="TYPE_Operation",
discriminatorType=DiscriminatorType.STRING)
public abstract class Operation implements Serializable{

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long numero;
@Temporal(TemporalType.DATE)
private Date date_opertaion;
private double montant;
@ManyToOne
@JoinColumn(name="CODE_Compte")
private Compte compte;
@ManyToOne
private Historique historique;
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
public Operation(Date date_opertaion, double montant, Compte compte) {
	super();
	this.date_opertaion = date_opertaion;
	this.montant = montant;
	this.compte = compte;
}
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}
public Date getDate_opertaion() {
	return date_opertaion;
}
public void setDate_opertaion(Date date_opertaion) {
	this.date_opertaion = date_opertaion;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public Historique getHistorique() {
	return historique;
}
public void setHistorique(Historique historique) {
	this.historique = historique;
}
@Override
public String toString() {
	return "Operation [numero=" + numero + ", date_opertaion=" + date_opertaion + ", montant=" + montant + ", compte="
			+ compte + ", historique=" + historique + "]";
}



}
