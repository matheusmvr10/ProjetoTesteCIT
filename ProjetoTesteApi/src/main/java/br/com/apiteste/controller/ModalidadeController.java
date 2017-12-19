package br.com.apiteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.apiteste.dao.ModalidadeDao;
import br.com.apiteste.entity.Modalidade;



@Controller
public class ModalidadeController {
	
	@RequestMapping(value="/createModalidade")
	@ResponseBody
	public String createModalidade(@RequestBody Modalidade modalidade){
		
		try {
			modalidadeDao.createModalidade(modalidade);
			
			
		} catch (Exception e) {
			return "Erro ao criar modalidade:" + e.toString();
		}	
		
			return "Modalidade cadastrado com sucesso";
				
	}
	
	@RequestMapping(value="/deleteModalidade")
	@ResponseBody
	public String deleteModalidade(long id) {
		try {
			Modalidade modalidade = new Modalidade();
			modalidade.setId(id);
	        modalidadeDao.deleteModalidade(modalidade);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar modalidade: " + ex.toString();
        }
        	return "Modalidade deletado com sucesso!";
    }
	
	@RequestMapping(value="/updateModalidade")
	@ResponseBody
	public String updateModalidade(@RequestBody Modalidade modalidade) {
	     try {
	        modalidadeDao.update(modalidade);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "Modalidade atualizado com sucesso!";
	     } 
	 
	@RequestMapping("/get-modalidade")
   	@ResponseBody
   	public Modalidade getId(long id) throws Exception {
   	 
		 try {
       	 Modalidade modalidade = modalidadeDao.getId(id);
       	 
       	 if(modalidade == null){
       		 throw new Exception("Não existe");
       	 }
       	         	 
       	 return modalidade;
        }
        catch (Exception e) {
       	 throw new Exception("Erro ao consultar modalidade");
        }
        
	 }
	

    @Autowired
    private ModalidadeDao modalidadeDao;

}
