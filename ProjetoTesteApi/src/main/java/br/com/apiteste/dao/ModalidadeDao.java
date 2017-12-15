package br.com.apiteste.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.apiteste.entity.Modalidade;

@Repository
@Transactional
public class ModalidadeDao {
	
	public void createModalidade(Modalidade modalidade){
		entityManager.persist(modalidade);
		
	}
	
	public void deleteModalidade(Modalidade modalidade){
		
		if(entityManager.contains(modalidade)){
			entityManager.remove(modalidade);
			
		}else{
			entityManager.remove(entityManager.merge(modalidade));
		}
		
	}
	//Consulta modalidade cadastrada
	public Modalidade getId(long id){
		return (Modalidade) entityManager.createQuery(
				"from Modalidade where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	public void update(Modalidade modalidade) {
		 
		 if(!entityManager.contains(modalidade)){
	    	 
			 	Modalidade mod = entityManager.find(modalidade.getClass(), modalidade.getId());

			 	mod.setNomeModalidade(mod.getNomeModalidade());
			 	
			 	modalidade = mod;
		    }
		       entityManager.merge(modalidade);
		    
		    return;
	 }
	
	@PersistenceContext
	EntityManager entityManager;

}
