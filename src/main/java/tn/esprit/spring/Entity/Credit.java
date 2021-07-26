package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credit implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float montant;
	private int duree;
	private double taux;
	private double écheances;
	private String Type_credit;
	@OneToOne
	private Client client;
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public double getTaux() {
		return taux;
	}



	public void setTaux(double taux) {
		this.taux = taux;
	}



	public double getÉcheances() {
		return écheances;
	}



	public void setÉcheances(double écheances) {
		this.écheances = écheances;
	}



	public Float getMontant() {
		return montant;
	}
	public void setMontant(Float montant) {
		this.montant = montant;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getType_credit() {
		return Type_credit;
	}
	public void setType_credit(String type_credit) {
		Type_credit = type_credit;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}




	public Credit(Float montant, int duree, double taux, double écheances, String type_credit) {
		super();
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.écheances = écheances;
		Type_credit = type_credit;
	}



	@Override
	public String toString() {
		return "Credit [id=" + id + ", montant=" + montant + ", duree=" + duree + ", taux=" + taux + ", écheances="
				+ écheances + ", Type_credit=" + Type_credit + ", client=" + client + "]";
	}


	
}
