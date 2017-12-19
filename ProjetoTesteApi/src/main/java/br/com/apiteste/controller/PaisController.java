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
	@RequestMapping(value="/updatePais")
	@ResponseBody
	public String updatePais(@RequestBody Pais pais) {
	     try {
	        paisDao.update(pais);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "País atualizado com sucesso!";
	     } 
	 
	@RequestMapping("/get-pais")
  	@ResponseBody
        public Pais getId(long id) throws Exception {
   	 
	 try {
       	     Pais pais = paisDao.getId(id);
       	 
       	 if(pais == null){
       		 throw new Exception("Não existe");
       	 }
       	         	 
       	 return pais;
        }
        catch (Exception e) {
       	 throw new Exception("Erro ao consultar país");
        }
        
	 }
	

    @Autowired
    private PaisDao paisDao;

}
