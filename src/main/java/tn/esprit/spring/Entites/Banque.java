package tn.esprit.spring.Entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Banque implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Nom_Bank,Email,Tel,Fax,Adresse;
	@OneToMany(mappedBy="banque")
	private List<Agence> agences;
	@OneToMany(mappedBy="banque")
	private List<PackProduit> packProduits;

	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Banque(Long id, String nom_Bank, String email, String tel, String fax, String adresse, List<Agence> agences,
			List<PackProduit> packProduits) {
		super();
		this.id = id;
		Nom_Bank = nom_Bank;
		Email = email;
		Tel = tel;
		Fax = fax;
		Adresse = adresse;
		this.agences = agences;
		this.packProduits = packProduits;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_Bank() {
		return Nom_Bank;
	}
	public void setNom_Bank(String nom_Bank) {
		Nom_Bank = nom_Bank;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public List<Agence> getAgences() {
		return agences;
	}
	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
	public List<PackProduit> getPackProduits() {
		return packProduits;
	}
	public void setPackProduits(List<PackProduit> packProduits) {
		this.packProduits = packProduits;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", Nom_Bank=" + Nom_Bank + ", Email=" + Email + ", Tel=" + Tel + ", Fax=" + Fax
				+ ", Adresse=" + Adresse + ", agences=" + agences + ", packProduits=" + packProduits + "]";
	}


	
	
}
