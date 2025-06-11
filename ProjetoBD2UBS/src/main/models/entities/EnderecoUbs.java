package main.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class EnderecoUbs {
	
	@Id
	private Integer id;
	@Column (name = "logradouro")
	private String rua;
	@Column (name = "bairro")
	private String bairro;
	@Column (name = "uf")
	private int uf;
	@Column (name = "ibge")
	private int ibge;
	@Column (name = "latitude")
	private String lat;
	@Column (name = "longitude")
	private String lon;
	@OneToOne
	@JoinColumn(name = "id_ubs")
	private Ubs ubs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getUf() {
		return uf;
	}
	public void setUf(int uf) {
		this.uf = uf;
	}
	public int getIbge() {
		return ibge;
	}
	public void setIbge(int ibge) {
		this.ibge = ibge;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("------------------------------------------------------\n");
		b.append("|Ubs: |"+ubs.getNome()+"\n");
		b.append("|rua: |"+rua+"\n");
		b.append("------------------------------------------------------\n");
		return b.toString();
	}
}
