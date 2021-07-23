package tn.esprit.spring.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contrainte {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idcontrainte;
private String type_contrainte;
private double Montant;
private int age ;

public Contrainte() {
	super();
	// TODO Auto-generated constructor stub
}

public Contrainte(String type_contrainte, double montant, int age) {
	super();
	this.type_contrainte = type_contrainte;
	Montant = montant;
	this.age = age;
}

public long getIdcontrainte() {
	return idcontrainte;
}

public void setIdcontrainte(long idcontrainte) {
	this.idcontrainte = idcontrainte;
}

public String getType_contrainte() {
	return type_contrainte;
}

public void setType_contrainte(String type_contrainte) {
	this.type_contrainte = type_contrainte;
}

public double getMontant() {
	return Montant;
}

public void setMontant(double montant) {
	Montant = montant;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	return "Contrainte [idcontrainte=" + idcontrainte + ", type_contrainte=" + type_contrainte + ", Montant=" + Montant
			+ ", age=" + age + "]";
}


}
