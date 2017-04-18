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

import fr.siga.dao.FormationRepository;
import fr.siga.entites.Formation;

@RestController
public class FormationService 
{
	@Autowired
	private FormationRepository fr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/formation",method=RequestMethod.GET)
	public List<Formation> listeFormations() 
	{
		return fr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/formation/{id}",method=RequestMethod.GET)
	public Optional<Formation> formation(@PathVariable("id")Long id) 
	{	
		return fr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/formation",method=RequestMethod.POST)
	public Formation ajoutetFormation(@RequestBody Formation f) 
	{
		return fr.save(f);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/formation/{id}",method=RequestMethod.PUT)
	public Formation modifierFormation(@RequestBody Formation f,@PathVariable("id")Long id)
	{
		return fr.saveAndFlush(f);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/formation/{id}",method=RequestMethod.DELETE)
	public void supprimerFormation(@PathVariable("id")Long id)
	{
		fr.delete(id);
	}
}