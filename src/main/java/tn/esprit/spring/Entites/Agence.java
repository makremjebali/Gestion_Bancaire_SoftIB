package tn.esprit.spring.Entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agence implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Agence_identifiant;
	private String Nom_Agence,Agence_adresse;
	@OneToMany(mappedBy="agence")
	private List<Compte> comptes;
	@ManyToOne
	private Banque banque;

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Agence(Long agence_identifiant, String nom_Agence, String agence_adresse, List<Compte> comptes,
			Banque banque) {
		super();
		Agence_identifiant = agence_identifiant;
		Nom_Agence = nom_Agence;
		Agence_adresse = agence_adresse;
		this.comptes = comptes;
		this.banque = banque;
	}



	public Long getAgence_identifiant() {
		return Agence_identifiant;
	}

	public void setAgence_identifiant(Long agence_identifiant) {
		Agence_identifiant = agence_identifiant;
	}

	public String getNom_Agence() {
		return Nom_Agence;
	}

	public void setNom_Agence(String nom_Agence) {
		Nom_Agence = nom_Agence;
	}

	public String getAgence_adresse() {
		return Agence_adresse;
	}

	public void setAgence_adresse(String agence_adresse) {
		Agence_adresse = agence_adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Agence [Agence_identifiant=" + Agence_identifiant + ", Nom_Agence=" + Nom_Agence + ", Agence_adresse="
				+ Agence_adresse + ", comptes=" + comptes + ", banque=" + banque + "]";
	}


	
	

}
