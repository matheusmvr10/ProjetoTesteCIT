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
	

    @Autowired
    private LocalDao localDao;

}
