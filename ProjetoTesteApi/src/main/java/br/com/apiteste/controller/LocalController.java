package br.com.apiteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.apiteste.dao.LocalDao;
import br.com.apiteste.entity.Local;


@Controller
public class LocalController {

	@RequestMapping(value="/createLocal")
	@ResponseBody
	public String createLocal(@RequestBody Local local){
		
		try {
			localDao.createLocal(local);
			
			
		} catch (Exception e) {
			return "Erro ao criar local:" + e.toString();
		}	
		
			return "Local cadastrado com sucesso";
				
	}
	
	@RequestMapping(value="/deleteLocal")
	@ResponseBody
	public String deleteLocal(long id) {
		try {
			Local local = new Local();
			local.setId(id);
	        localDao.deleteLocal(local);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar modalidade: " + ex.toString();
        }
        	return "Modalidade deletado com sucesso!";
    }
	
	@RequestMapping(value="/updateLocal")
	@ResponseBody
	public String updateLocal(@RequestBody Local local) {
	     try {
	        localDao.update(local);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "Local atualizado com sucesso!";
	     } 
	 
	@RequestMapping("/get-local")
    	@ResponseBody
    	public Local getId(long id) throws Exception {
   	 
		try {
       	 		Local local = localDao.getId(id);
       	 
       	 	if(local == null){
       		      throw new Exception("Não existe");
       	 	}
       	         	 
       	 return local;
        }
        catch (Exception e) {
       	 throw new Exception("Erro ao consultar local");
        }
        
	 }

    @Autowired
    private LocalDao localDao;

}
