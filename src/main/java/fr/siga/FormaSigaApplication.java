package fr.siga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import fr.siga.dao.RoleRepository;
import fr.siga.entites.Role;

@SpringBootApplication
public class FormaSigaApplication 
{
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(FormaSigaApplication.class, args);
				
		RoleRepository r = ctx.getBean(RoleRepository.class);
				
		r.save(new Role("ADMIN","Administrateur de société."));
		r.save(new Role("RESPONSABLE","Le responsable des ressources humaines de société."));
		r.save(new Role("CHEF","Le chef hiérarchique de société."));
		r.save(new Role("EMPLOYE","Un employé travail au sein de société SIGA."));
	}
}
