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
	@Column(name = "NOME")
	private String nome;
	
	
	public int getCnes() {
		return cnes;
	}
	public void setCnes(int cnes) {
		this.cnes = cnes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
