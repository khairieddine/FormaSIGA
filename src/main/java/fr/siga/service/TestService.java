package fr.siga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.TestRepository;
import fr.siga.entites.Test;

@RestController
public class TestService 
{
	@Autowired
	private TestRepository tr;

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public List<Test> listeTests() 
	{
		return tr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/test/{id}",method=RequestMethod.GET)
	public Optional<Test> test(@PathVariable("id")Long id) 
	{	
		return tr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public Test ajoutetTest(@RequestBody Test t) 
	{
		System.out.println("MKD:POST:test:ajoutetTest");
		return tr.save(t);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/test/{id}",method=RequestMethod.PUT)
	public Test modifierTest(@RequestBody Test t,@PathVariable("id")Long id)
	{
		return tr.saveAndFlush(t);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/test/{id}",method=RequestMethod.DELETE)
	public void supprimerTheme(@PathVariable("id")Long id)
	{
		tr.delete(id);
	}
}
