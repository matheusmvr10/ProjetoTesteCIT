package br.com.apiteste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="pais")
public class Pais {
	
	@Id
	private long Id;
	
	@Column(nullable=false)
	private String nomePais;
			
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNomePais() {
		return nomePais;
	}
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	
	public Pais(){}
}
