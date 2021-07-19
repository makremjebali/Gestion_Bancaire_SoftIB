package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte implements Serializable{
		
	@Id
	private String Compte_identifiant;
	private String Type_cpte;
	@Temporal(TemporalType.DATE)
	private Date Date_ouverture;
	private double Solde;
	@ManyToOne
	private Agence agence;
	
	@OneToOne
	private Cartes_Bancaires carteBancaire;
	@ManyToOne
	@JoinColumn(name="CODE_client")
	private Client clients;
	@OneToMany(mappedBy="compte")
	private List<Operation>operations;

	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Compte(String compte_identifiant, String type_cpte, Date date_ouverture, double solde, Agence agence,
			Cartes_Bancaires carteBancaire, Client clients, List<Operation> operations) {
		super();
		Compte_identifiant = compte_identifiant;
		Type_cpte = type_cpte;
		Date_ouverture = date_ouverture;
		Solde = solde;
		this.agence = agence;
		this.carteBancaire = carteBancaire;
		this.clients = clients;
		this.operations = operations;
	}


	public String getCompte_identifiant() {
		return Compte_identifiant;
	}


	public void setCompte_identifiant(String compte_identifiant) {
		Compte_identifiant = compte_identifiant;
	}


	public String getType_cpte() {
		return Type_cpte;
	}


	public void setType_cpte(String type_cpte) {
		Type_cpte = type_cpte;
	}


	public Date getDate_ouverture() {
		return Date_ouverture;
	}


	public void setDate_ouverture(Date date_ouverture) {
		Date_ouverture = date_ouverture;
	}


	public double getSolde() {
		return Solde;
	}


	public void setSolde(double solde) {
		Solde = solde;
	}

	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	public Cartes_Bancaires getCarteBancaire() {
		return carteBancaire;
	}


	public void setCarteBancaire(Cartes_Bancaires carteBancaire) {
		this.carteBancaire = carteBancaire;
	}


	public Client getClients() {
		return clients;
	}


	public void setClients(Client clients) {
		this.clients = clients;
	}


	public List<Operation> getOperations() {
		return operations;
	}


	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}


	@Override
	public String toString() {
		return "Compte [Compte_identifiant=" + Compte_identifiant + ", Type_cpte=" + Type_cpte + ", Date_ouverture="
				+ Date_ouverture + ", Solde=" + Solde + ", agence=" + agence + ", carteBancaire=" + carteBancaire
				+ ", clients=" + clients + ", operations=" + operations + "]";
	}




	

}
