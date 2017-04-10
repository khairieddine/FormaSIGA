package fr.siga.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.EmployeRepository;
import fr.siga.entites.Employe;

@RestController
public class EmployeService 
{
	@Autowired
	private EmployeRepository er;
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/listesEmployesPage",method=RequestMethod.GET)
	public Page<Employe> listesEmployes(@RequestParam(name="page",defaultValue="1")int page,@RequestParam(name="size",defaultValue="10")int size)
	{
		return er.findAll(new PageRequest(page, size));
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/listesEmployes",method=RequestMethod.GET)
	public List<Employe> listesEmployes()
	{
		return er.findAll();
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.GET)
	public Optional<Employe> employe(@PathVariable("id")Long id)
	{
		return er.findOne(id);
	}

	@RequestMapping(value="/employe",method=RequestMethod.POST)
	public Employe ajouterEmploye(@RequestBody Employe e)
	{
		return er.save(e);
	}

	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.PUT)
	public Employe modifierEmploye(@RequestBody Employe e,@PathVariable("id")Long id)
	{
		e.setId(id);
		return er.saveAndFlush(e);
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.DELETE)
	public void supprimerEmploye(@PathVariable("id")Long id)
	{
		er.delete(id);
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/chercherEmployePage",method=RequestMethod.GET)
	public Page<Employe> chercherEmployePage(@Param("x") String mc,@RequestParam(name="page",defaultValue="1")int page,@RequestParam(name="size",defaultValue="10")int size)
	{
		return er.chercherEmployePage("%"+mc+"%", new PageRequest(page, size));
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/chercherEmploye",method=RequestMethod.GET)
	public List<Employe> chercherEmploye(@Param("x") String mc)
	{
		return er.chercherEmploye("%"+mc+"%");
	}
}
