package br.com.apiteste.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.apiteste.entity.Local;

@Repository
@Transactional
public class LocalDao {


	
	public void createLocal(Local local){
		entityManager.persist(local);
		return;
	}
	
	public void deleteLocal(Local local){
		
		if(entityManager.contains(local)){
			entityManager.remove(local);
			
		}else{
			entityManager.remove(entityManager.merge(local));
		}
		
	}
	
	public Local getId(long id){
		return (Local) entityManager.createQuery(
				"from Local where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	public void update(Local local) {
		 
		 if(!entityManager.contains(local)){
	    	 
			 	Local loc = entityManager.find(local.getClass(), local.getId());

			 	loc.setNomeLocal(loc.getNomeLocal());
			 	
			 	local = loc;
		    }
		       entityManager.merge(local);
		    
		    return;
	 }
	
	 @PersistenceContext
	 private EntityManager entityManager;
}
