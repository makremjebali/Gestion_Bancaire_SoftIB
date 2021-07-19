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
	private String Type_credit;
	@OneToOne(mappedBy="credit")
	private Client client;
	public Credit() {
		super();
		// TODO Auto-generated constructor stub
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
	public Credit(Float montant, int duree, String type_credit, Client client) {
		super();
		this.montant = montant;
		this.duree = duree;
		Type_credit = type_credit;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Credit [id=" + id + ", montant=" + montant + ", duree=" + duree + ", Type_credit=" + Type_credit
				+ ", client=" + client + "]";
	}

	
}
