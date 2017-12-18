package br.com.apiteste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQuery(name="Competicao.consultaCompeticao", query="SELECT count(*) FROM Competicao  WHERE idLocal = :idLocal AND dataHoraIni between :dataHoraIni AND :dataHoraFim"
		+ " AND dataHoraFim between :dataHoraIni AND :dataHoraFim")
@Entity
@Table(name ="competicao")
public class Competicao {

	@Id
	private long id;
	
    @Column(nullable=false)
	private long primeiroPais;
	
    @Column(nullable=false)
    private long segundoPais;
	
    @Column(nullable=false)
	private Date dataHoraIni;
    
    @Column(nullable=false)
	private Date dataHoraFim;

    @Column(nullable=false)
	private long idEtapa;
    
    @Column(nullable=false)
	private long idLocal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataHoraIni() {
		return dataHoraIni;
	}

	public long getPrimeiroPais() {
		return primeiroPais;
	}

	public void setPrimeiroPais(long primeiroPais) {
		this.primeiroPais = primeiroPais;
	}

	public long getSegundoPais() {
		return segundoPais;
	}

	public void setSegundoPais(long segundoPais) {
		this.segundoPais = segundoPais;
	}

	public void setDataHoraIni(Date dataHoraIni) {
		this.dataHoraIni = dataHoraIni;
	}

	public Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public long getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(long idEtapa) {
		this.idEtapa = idEtapa;
	}

	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

}
