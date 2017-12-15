package br.com.apiteste.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.apiteste.entity.Etapa;

@Repository
@Transactional
public class EtapaDao {

	
	public void createEtapa(Etapa etapa){
		entityManager.persist(etapa);
		return;
	}
	
	public void deleteEtapa(Etapa etapa){
		
		if(entityManager.contains(etapa)){
			entityManager.remove(etapa);
			
		}else{
			entityManager.remove(entityManager.merge(etapa));
		}
		
	}
	
	public Etapa getId(long id){
		return (Etapa) entityManager.createQuery(
				"from Etapa where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	public void update(Etapa etapa) {
		 
		 if(!entityManager.contains(etapa)){
	    	 
			 	Etapa etap = entityManager.find(etapa.getClass(), etapa.getId());

			 	etap.setEliminatoria(etapa.getEliminatoria());
		    	
			 	etapa = etap;
		    }
		       entityManager.merge(etapa);
		    
		    return;
	 }
	
	 @PersistenceContext
	 private EntityManager entityManager;
}
