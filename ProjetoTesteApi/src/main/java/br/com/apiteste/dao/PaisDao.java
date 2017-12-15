package br.com.apiteste.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.apiteste.entity.Pais;

@Repository
@Transactional
public class PaisDao {

	
	public void createPais(Pais pais){
		entityManager.persist(pais);
		return;
	}
	
	public void deletePais(Pais pais){
		
		if(entityManager.contains(pais)){			
			entityManager.remove(pais);
		
		}else{			
			entityManager.remove(entityManager.merge(pais));
		}
				
	}
	
	public Pais getId(long id){
		return (Pais) entityManager.createQuery(
				"from Pais where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	public void update(Pais pais) {
		 
		 if(!entityManager.contains(pais)){
	    	 
			 	Pais pa = entityManager.find(pais.getClass(), pais.getId());

			 	pais.setNomePais(pa.getNomePais());
			 	
			 	pais = pa;
		    }
		       entityManager.merge(pais);
		    
		    return;
	 }
	
	
	 @PersistenceContext
	 private EntityManager entityManager;
	  
}
