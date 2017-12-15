package br.com.apiteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.apiteste.dao.PaisDao;
import br.com.apiteste.entity.Pais;



@Controller
public class PaisController {
	
	@RequestMapping(value="/createPais")
	@ResponseBody
	public String createPais(@RequestBody Pais pais){
		
		try {
			paisDao.createPais(pais);
			
			
		} catch (Exception e) {
			return "Erro ao criar país:" + e.toString();
		}	
		
			return "País cadastrado com sucesso!";
				
	}
	
	@RequestMapping(value="/deletePais")
	@ResponseBody
	public String deletePais(long id) {
		try {
			Pais pais = new Pais();
			pais.setId(id);
	        paisDao.deletePais(pais);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar país: " + ex.toString();
        }
        	return "País deletado com sucesso!";
    }
	

    @Autowired
    private PaisDao paisDao;

}
