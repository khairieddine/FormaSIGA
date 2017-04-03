package fr.siga;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import fr.siga.dao.EmployeRepository;
import fr.siga.entites.Employe;

@SpringBootApplication
public class FormaSigaApplication 
{

	public static void main(String[] args) 
	{
		//SpringApplication.run(FormaSigaApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(FormaSigaApplication.class, args);
		
		EmployeRepository e = ctx.getBean(EmployeRepository.class);
		
//		Employe(String cin, String nom, String prenom, byte age, Date dateNaissance, String lieuNaissance,
//				String sex, boolean estMarie, String photo, String adresse, Long tele, String email,
//				Employe directeurEmploye, String compteBanquaire, String poste) 
		
		e.save(new Employe("12345678","khairieddine","mechergui",(byte)23,new Date(),"Jendouba","homme",false,"","Nacer city Jendouba",558880347,"khairieddine.mechergui@gmail.com",null,"",""));
		e.save(new Employe("12365412","khaled","mechergui",(byte)23,new Date(),"Jendouba","homme",false,"","Nacer city Jendouba",56321455,"khaled.mechergui@gmail.com",null,"",""));
		e.save(new Employe("54123698","raja","mechergui",(byte)23,new Date(),"Jendouba","homme",false,"","Nacer city Jendouba",55541257,"raja.mechergui@gmail.com",null,"",""));
	}
}
