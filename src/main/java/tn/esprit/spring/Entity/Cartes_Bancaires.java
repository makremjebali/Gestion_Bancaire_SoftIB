package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cartes_Bancaires implements Serializable {
	@Id
	private int Numero_carte;
	private int mot_passe;
	private String duree_de_validite;
	@OneToOne
	private Compte compte;
	public Cartes_Bancaires() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cartes_Bancaires(int numero_carte, int mot_passe, String duree_de_validite, Compte compte) {
		super();
		Numero_carte = numero_carte;
		this.mot_passe = mot_passe;
		this.duree_de_validite = duree_de_validite;
		this.compte = compte;
	}
	public int getNumero_carte() {
		return Numero_carte;
	}
	public void setNumero_carte(int numero_carte) {
		Numero_carte = numero_carte;
	}
	public int getMot_passe() {
		return mot_passe;
	}
	public void setMot_passe(int mot_passe) {
		this.mot_passe = mot_passe;
	}
	public String getDuree_de_validite() {
		return duree_de_validite;
	}
	public void setDuree_de_validite(String duree_de_validite) {
		this.duree_de_validite = duree_de_validite;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	@Override
	public String toString() {
		return "Cartes_Bancaires [Numero_carte=" + Numero_carte + ", mot_passe=" + mot_passe + ", duree_de_validite="
				+ duree_de_validite + ", compte=" + compte + "]";
	}
	
	
}
