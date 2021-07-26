package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,
property="type_cpte")
@JsonSubTypes({@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
})
public abstract class Compte implements Serializable{
		
	@Id
	private String Compte_identifiant;
	@Temporal(TemporalType.DATE)
	private Date Date_ouverture;
	private double Solde;
	@ManyToOne(cascade = CascadeType.ALL)
	private Agence agence;
	
	@OneToOne(mappedBy="compte")
	private Cartes_Bancaires carteBancaire;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CODE_client")
	private Client clients;
	@OneToMany(mappedBy="compte",fetch=FetchType.EAGER)
	private List<Operation>operations;

	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Compte(String compte_identifiant, Date date_ouverture, double solde) {
		super();
		Compte_identifiant = compte_identifiant;
		Date_ouverture = date_ouverture;
		Solde = solde;
	}






	public Compte(String compte_identifiant, Date date_ouverture, double solde, Agence agence,
			Cartes_Bancaires carteBancaire, Client clients) {
		super();
		Compte_identifiant = compte_identifiant;
		Date_ouverture = date_ouverture;
		Solde = solde;
		this.agence = agence;
		this.carteBancaire = carteBancaire;
		this.clients = clients;
	}




	public Compte(String compte_identifiant, Date date_ouverture, double solde, Agence agence,
			Cartes_Bancaires carteBancaire, Client clients, List<Operation> operations) {
		super();
		Compte_identifiant = compte_identifiant;
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

	//@JsonIgnore
	public Client getClients() {
		return clients;
	}

	//@JsonSetter
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
		return "Compte [Compte_identifiant=" + Compte_identifiant + ", Date_ouverture=" + Date_ouverture + ", Solde="
				+ Solde + ", agence=" + agence + ", carteBancaire=" + carteBancaire + ", clients=" + clients
				+ ", operations=" + operations + "]";
	}





	

}
