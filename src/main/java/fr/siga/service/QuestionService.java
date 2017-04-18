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

import fr.siga.dao.QuestionRepository;
import fr.siga.entites.Question;

@RestController
public class QuestionService 
{
	@Autowired
	private QuestionRepository qr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/question",method=RequestMethod.GET)
	public List<Question> listeQuestions() 
	{
		return qr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/question/{id}",method=RequestMethod.GET)
	public Optional<Question> test(@PathVariable("id")Long id) 
	{	
		return qr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/question",method=RequestMethod.POST)
	public Question ajoutetQuestion(@RequestBody Question q) 
	{
		return qr.save(q);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/question/{id}",method=RequestMethod.PUT)
	public Question modifierQuestion(@RequestBody Question q,@PathVariable("id")Long id)
	{
		return qr.saveAndFlush(q);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/question/{id}",method=RequestMethod.DELETE)
	public void supprimerQuestion(@PathVariable("id")Long id)
	{
		qr.delete(id);
	}
}
