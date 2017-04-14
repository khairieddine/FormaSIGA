package fr.siga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.SuggestionRepository;
import fr.siga.entites.Suggestion;

@RestController
public class SuggestionService 
{
	@Autowired
	private SuggestionRepository sr;
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/listeSuggestions",method=RequestMethod.GET)
	public List<Suggestion> listeSuggestions()
	{
		return sr.findAll();
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/suggestion/{id}",method=RequestMethod.GET)
	public Optional<Suggestion> suggestion(@PathVariable("id")Long id)
	{
		return sr.findOne(id);
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/suggestion",method=RequestMethod.POST)
	public Suggestion ajouterSuggestion(@RequestBody Suggestion s)
	{
		return sr.save(s);
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/suggestion/{id}",method=RequestMethod.PUT)
	public Suggestion modifierSuggestion(@RequestBody Suggestion s,@PathVariable("id")Long id)
	{
		s.setId(id);
		return sr.saveAndFlush(s);
	}
	
	//@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/suggestion/{id}",method=RequestMethod.DELETE)
	public void supprimerSuggestion(@PathVariable("id")Long id)
	{
		sr.delete(id);
	}
}
