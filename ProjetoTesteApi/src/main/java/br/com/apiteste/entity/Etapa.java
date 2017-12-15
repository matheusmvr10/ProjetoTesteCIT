package br.com.apiteste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "etapa")
public class Etapa {
	
	@Id
	private long Id;
	
	@Column(nullable=false)
	private String eliminatoria;
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getEliminatoria() {
		return eliminatoria;
	}
	public void setEliminatoria(String eliminatoria) {
		this.eliminatoria = eliminatoria;
	}
	
	public Etapa(){}

}
