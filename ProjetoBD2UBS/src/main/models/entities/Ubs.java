package main.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UnidadesDeSaude", schema = "dbo")

public class Ubs {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "CNES")
	private int cnes;
	@Column(name = "UF")
	private int uf;
	@Column(name = "IBGE")
	private int ibge;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "LOGRADOURO")
	private String rua;
	@Column(name = "BAIRRO")
	private String bairro;
	@Column(name = "LONGITUDE")
	private String longitude;
	@Column(name = "LATITUDE")
	private String latitude;
	
	
	public int getCnes() {
		return cnes;
	}
	public void setCnes(int cnes) {
		this.cnes = cnes;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public double getLongitude() {
		String trocarVirgula = longitude.replace(",", ".");
		double resultado = Double.parseDouble(trocarVirgula);
		return resultado;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		String trocarVirgula = longitude.replace(",", ".");
		double resultado = Double.parseDouble(trocarVirgula);
		return resultado;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "Ubs [cnes=" + cnes + ", uf=" + uf + ", ibge=" + ibge + ", nome=" + nome + ", rua=" + rua + ", bairro="
				+ bairro + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	
}
