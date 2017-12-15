package br.com.apiteste.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.apiteste.entity.Competicao;

@Repository
@Transactional
public class CompeticaoDao {
	
	
	public Competicao createCompeticao(Competicao competicao) {		
		entityManager.persist(competicao);
		return competicao;
	}
	
	
	//Verifica se existe uma comeptição no mesmo lugar com mesmo horário
	public boolean existeCompeticao(Competicao competicao) {
		
				long quantidade = this.entityManager
			.createNamedQuery("Competicao.consultaCompeticao", Long.class)
			.setParameter("idLocal", competicao.getIdLocal())
			.setParameter("dataHoraIni", competicao.getDataHoraIni())
			.setParameter("dataHoraFim",competicao.getDataHoraFim())
			.getSingleResult();

		if(quantidade > 0) {
			return true;
		}
		
		return false;
	}
	
	public void deleteCompeticao(Competicao competicao) {
		
		if(entityManager.contains(competicao)){
			entityManager.remove(competicao);
			
		}else{
			entityManager.remove(entityManager.merge(competicao));
		}
		
	}
	
	public Competicao getId(long id){
		return (Competicao) entityManager.createQuery(
				"from Competicao where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	public void update(Competicao competicao) {
		 
		 if(!entityManager.contains(competicao)){
	    	 
			 	Competicao compet = entityManager.find(competicao.getClass(), competicao.getId());

			 	compet.setIdLocal(competicao.getIdLocal());
			 	compet.setIdEtapa(competicao.getIdEtapa());
			 	compet.setDataHoraIni(competicao.getDataHoraIni());
			 	compet.setDataHoraFim(competicao.getDataHoraFim());
		    	
			 	competicao = compet;
		    }
		       entityManager.merge(competicao);
		    
		    return;
	 }
	
	
	 @PersistenceContext
	 private EntityManager entityManager;
	  

}
