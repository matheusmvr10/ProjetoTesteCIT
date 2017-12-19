package br.com.apiteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.apiteste.dao.CompeticaoDao;
import br.com.apiteste.entity.Competicao;
import br.com.apiteste.service.CompeticaoService;

@Controller
public class CompeticaoController {
	
	@Autowired
	CompeticaoService competicaoService;

	@RequestMapping(value="/createCompeticao")
	@ResponseBody
	public String createPais(@RequestBody Competicao competicao){
		
		try {
			
			competicaoService.createCompeticao(competicao);
			
								
		} catch (Exception e) {
			return "Erro ao criar competição:" + e.toString();
		}	
		
			return "Competição cadastrado com sucesso!";
				
	}
	
	@RequestMapping(value="/deleteCompeticao")
	@ResponseBody
	public String deletePais(long id) {
		try {
			Competicao competicao = new Competicao();
			competicao.setId(id);
	        competicaoDao.deleteCompeticao(competicao);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar país: " + ex.toString();
        }
        	return "País deletado com sucesso!";
       }
	@RequestMapping(value="/updateCompeticao")
	@ResponseBody
	 public String updateCompeticao(@RequestBody Competicao competicao) {
	     try {
	        competicaoDao.update(competicao);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "Competição atualizado com sucesso!";
	     } 
	 
     @RequestMapping("/get-competicao")
     @ResponseBody
     public Competicao getId(long id) throws Exception {
    	 
		 try {
        	 Competicao competicao = competicaoDao.getId(id);
        	 
        	 if(competicao == null){
        		 throw new Exception("Não existe");
        	 }
        	         	 
        	 return competicao;
         }
         catch (Exception e) {
        	 throw new Exception("Erro ao consultar competição");
         }
         
	 }
	
	@Autowired
	CompeticaoDao competicaoDao;

}
