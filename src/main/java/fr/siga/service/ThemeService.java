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

import fr.siga.dao.ThemeRepository;
import fr.siga.entites.Theme;

@RestController
public class ThemeService 
{
	@Autowired
	private ThemeRepository tr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/theme",method=RequestMethod.GET)
	public List<Theme> listeThemes() 
	{
		return tr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/theme/{id}",method=RequestMethod.GET)
	public Optional<Theme> theme(@PathVariable("id")Long id) 
	{	
		return tr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/theme",method=RequestMethod.POST)
	public Theme ajoutetTheme(@RequestBody Theme t) 
	{
		return tr.save(t);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/theme/{id}",method=RequestMethod.PUT)
	public Theme modifierTheme(@RequestBody Theme t,@PathVariable("id")Long id)
	{
		return tr.saveAndFlush(t);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/theme/{id}",method=RequestMethod.DELETE)
	public void supprimerTheme(@PathVariable("id")Long id)
	{
		tr.delete(id);
	}
}
