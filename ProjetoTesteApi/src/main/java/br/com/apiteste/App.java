package br.com.apiteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses={EtapaDao.class,EtapaController.class,ModalidadeDao.class,ModalidadeController.class,
//		PaisDao.class,PaisController.class,LocalDao.class,LocalController.class,CompeticaoDao.class,CompeticaoController.class})
//@Controller
//@EntityScan(basePackageClasses={Etapa.class, Modalidade.class, Pais.class,Local.class,Competicao.class})
@SpringBootApplication
public class App 
{
	
	String entry(){
		return "Meu Spring teste";
	}
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
