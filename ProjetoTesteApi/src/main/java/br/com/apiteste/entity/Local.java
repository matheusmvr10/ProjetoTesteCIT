package br.com.apiteste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="local")
public class Local {
		
		@Id
		private long Id;
		
		@Column(nullable=false)
		private String nomeLocal;
			
		public long getId() {
			return Id;
		}
		public void setId(long id) {
			Id = id;
		}
		public String getNomeLocal() {
			return nomeLocal;
		}
		public void setNomeLocal(String nomeLocal) {
			this.nomeLocal = nomeLocal;
		}
		
		public Local(){}
	
}
