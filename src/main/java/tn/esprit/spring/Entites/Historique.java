package tn.esprit.spring.Entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historique implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String description,typeoperation;
	private double montant, Solde;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="historique")
	private List<Operation>  operations;
	@OneToOne
	private Compte compte;

	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Historique(Date date, String description, String typeoperation, double montant, double solde) {
		super();
		this.date = date;
		this.description = description;
		this.typeoperation = typeoperation;
		this.montant = montant;
		Solde = solde;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeoperation() {
		return typeoperation;
	}

	public void setTypeoperation(String typeoperation) {
		this.typeoperation = typeoperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public double getSolde() {
		return Solde;
	}

	public void setSolde(double solde) {
		Solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Historique [id=" + id + ", date=" + date + ", description=" + description + ", typeoperation="
				+ typeoperation + ", montant=" + montant + ", Solde=" + Solde + ", operations=" + operations
				+ ", compte=" + compte + "]";
	}

	
}
