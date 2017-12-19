package br.com.apiteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.apiteste.dao.EtapaDao;
import br.com.apiteste.entity.Etapa;


@Controller
public class EtapaController {

	@RequestMapping(value="/createEtapa")
	@ResponseBody
	public String createPrescricao(@RequestBody Etapa etapa){
		
		try {
			
			etapaDao.createEtapa(etapa);
			
			
		} catch (Exception e) {
			return "Erro ao criar prescrição:" + e.toString();
		}	
		
			return "Prescrição criada com sucesso";
				
	}
	
	@RequestMapping(value="/deleteEtapa")
	@ResponseBody
	public String deleteEtapa(long id) {
		try {
			Etapa etapa = new Etapa();
			etapa.setId(id);
	        etapaDao.deleteEtapa(etapa);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar etapa: " + ex.toString();
         }
        	return "Etapa deletado com sucesso!";
       }
	@RequestMapping(value="/updateEtapa")
	@ResponseBody
	public String updateEtapa(@RequestBody Etapa etapa) {
	     try {
	        etapaDao.update(etapa);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "Etapa atualizado com sucesso!";
	     } 
	 
	@RequestMapping("/get-etapa")
   	@ResponseBody
    	public Etapa getId(long id) throws Exception {
   	 
		 try {
       	 Etapa etapa = etapaDao.getId(id);
       	 
       	 if(etapa == null){
       		 throw new Exception("Não existe");
       	 }
       	         	 
       	 return etapa;
        }
        catch (Exception e) {
       	 throw new Exception("Erro ao consultar etapa");
        }
        
	}
	
	
	@Autowired
	EtapaDao  etapaDao;

}
