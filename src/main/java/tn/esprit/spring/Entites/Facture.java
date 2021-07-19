package tn.esprit.spring.Entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Num_Facture;
	@Temporal(TemporalType.DATE)
	private Date date_facture;
	@ManyToOne(cascade=CascadeType.ALL)
	private Client client;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(Long id, String num_Facture, Date date_facture, Client client) {
		super();
		this.id = id;
		Num_Facture = num_Facture;
		this.date_facture = date_facture;
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNum_Facture() {
		return Num_Facture;
	}
	public void setNum_Facture(String num_Facture) {
		Num_Facture = num_Facture;
	}
	public Date getDate_facture() {
		return date_facture;
	}
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Facture [id=" + id + ", Num_Facture=" + Num_Facture + ", date_facture=" + date_facture + ", client="
				+ client + "]";
	}
	
	
}
