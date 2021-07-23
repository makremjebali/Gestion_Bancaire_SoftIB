package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class PackProduit implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Type_Pack;
	@ManyToOne
	@JsonIgnore
	private Banque banque;
	public PackProduit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PackProduit(Long id, String type_Pack, Banque banque) {
		super();
		this.id = id;
		Type_Pack = type_Pack;
		this.banque = banque;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType_Pack() {
		return Type_Pack;
	}
	public void setType_Pack(String type_Pack) {
		Type_Pack = type_Pack;
	}
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	@Override
	public String toString() {
		return "PackProduit [id=" + id + ", Type_Pack=" + Type_Pack + ", banque=" + banque + "]";
	}
	
	
}
