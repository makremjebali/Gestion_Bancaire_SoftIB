package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Client_identifiant;
	private String Nom_client,Adresse_client;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private Long Code_postal;
	private String Ville,Tel;
	@Enumerated(EnumType.STRING)
	private Type Type_client;
	@Column(nullable=true)
	private String travail;
	@Column(nullable=true)
	private float salaire;
	
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Facture> facture; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clients")
	private List<Compte> comptes;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Intervention> interventions;
	
	@OneToOne(mappedBy="client")
	private Credit credit;
	
	@OneToOne
	private User user;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom_client, String adresse_client, Date dateNaissance, Long code_postal, String ville,
			String tel, Type type_client, String travail, float salaire, List<Facture> facture, List<Compte> comptes,
			List<Intervention> interventions, Credit credit, User user) {
		super();
		Nom_client = nom_client;
		Adresse_client = adresse_client;
		this.dateNaissance = dateNaissance;
		Code_postal = code_postal;
		Ville = ville;
		Tel = tel;
		Type_client = type_client;
		this.travail = travail;
		this.salaire = salaire;
		this.facture = facture;
		this.comptes = comptes;
		this.interventions = interventions;
		this.credit = credit;
		this.user = user;
	}
	
	

	public Client(String nom_client, Type type_client, User user) {
		super();
		Nom_client = nom_client;
		Type_client = type_client;
		this.user = user;
	}

	public Long getClient_identifiant() {
		return Client_identifiant;
	}

	public void setClient_identifiant(Long client_identifiant) {
		Client_identifiant = client_identifiant;
	}

	public String getNom_client() {
		return Nom_client;
	}

	public void setNom_client(String nom_client) {
		Nom_client = nom_client;
	}

	public String getAdresse_client() {
		return Adresse_client;
	}

	public void setAdresse_client(String adresse_client) {
		Adresse_client = adresse_client;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Long getCode_postal() {
		return Code_postal;
	}

	public void setCode_postal(Long code_postal) {
		Code_postal = code_postal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public Type getType_client() {
		return Type_client;
	}

	public void setType_client(Type type_client) {
		Type_client = type_client;
	}

	public String getTravail() {
		return travail;
	}

	public void setTravail(String travail) {
		this.travail = travail;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public List<Facture> getFacture() {
		return facture;
	}

	public void setFacture(List<Facture> facture) {
		this.facture = facture;
	}
	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Client [Client_identifiant=" + Client_identifiant + ", Nom_client=" + Nom_client + ", Adresse_client="
				+ Adresse_client + ", dateNaissance=" + dateNaissance + ", Code_postal=" + Code_postal + ", Ville="
				+ Ville + ", Tel=" + Tel + ", Type_client=" + Type_client + ", travail=" + travail + ", salaire="
				+ salaire + ", facture=" + facture + ", comptes=" + comptes + ", interventions=" + interventions
				+ ", credit=" + credit + ", user=" + user + "]";
	}

	
}
