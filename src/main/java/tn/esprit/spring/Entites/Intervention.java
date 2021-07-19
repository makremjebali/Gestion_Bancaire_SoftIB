package tn.esprit.spring.Entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Intervention implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Titre;
	@Enumerated(EnumType.STRING)
	private TypeIntervention intervention;
	private String Suject;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="interventions")
	private List<Client> clients;
	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Intervention(String titre, TypeIntervention intervention, String suject, List<Client> clients) {
		super();
		Titre = titre;
		this.intervention = intervention;
		Suject = suject;
		this.clients = clients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public TypeIntervention getIntervention() {
		return intervention;
	}
	public void setIntervention(TypeIntervention intervention) {
		this.intervention = intervention;
	}
	public String getSuject() {
		return Suject;
	}
	public void setSuject(String suject) {
		Suject = suject;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "Intervention [id=" + id + ", Titre=" + Titre + ", intervention=" + intervention + ", Suject=" + Suject
				+ ", clients=" + clients + "]";
	}
	

}
