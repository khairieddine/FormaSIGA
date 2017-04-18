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

import fr.siga.dao.GroupeRepository;
import fr.siga.entites.Groupe;

@RestController
public class GroupeService 
{
	@Autowired
	private GroupeRepository gr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/groupe",method=RequestMethod.GET)
	public List<Groupe> listeGroupes() 
	{
		return gr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/groupe/{id}",method=RequestMethod.GET)
	public Optional<Groupe> groupe(@PathVariable("id")Long id) 
	{	
		return gr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/groupe",method=RequestMethod.POST)
	public Groupe ajoutetGroupe(@RequestBody Groupe g) 
	{
		return gr.save(g);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/groupe/{id}",method=RequestMethod.PUT)
	public Groupe modifierGroupe(@RequestBody Groupe g,@PathVariable("id")Long id)
	{
		return gr.saveAndFlush(g);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/groupe/{id}",method=RequestMethod.DELETE)
	public void supprimerGroupe(@PathVariable("id")Long id)
	{
		gr.delete(id);
	}
}
