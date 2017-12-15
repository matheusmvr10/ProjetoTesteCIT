package br.com.apiteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apiteste.dao.CompeticaoDao;
import br.com.apiteste.entity.Competicao;

@Service
public class CompeticaoService {

	
	@Autowired
	CompeticaoDao dao;
	
	public void createCompeticao(Competicao competicao) {
				
		try {
			boolean jaExiste = dao.existeCompeticao(competicao);
			
			if(!jaExiste) {
				dao.createCompeticao(competicao);
			}
		} catch (Exception e) {
			return;
		}
		
	}
	
}
