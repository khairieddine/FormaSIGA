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

import fr.siga.dao.ParticipantRepository;
import fr.siga.entites.Participant;

@RestController
public class ParticipantService 
{
	@Autowired
	private ParticipantRepository pr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/participant",method=RequestMethod.GET)
	public List<Participant> listeParticipants() 
	{
		return pr.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/participant/{id}",method=RequestMethod.GET)
	public Optional<Participant> participant(@PathVariable("id")Long id) 
	{	
		return pr.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/participant",method=RequestMethod.POST)
	public Participant ajoutetParticipant(@RequestBody Participant p) 
	{
		return pr.save(p);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/participant/{id}",method=RequestMethod.PUT)
	public Participant modifierParticipant(@RequestBody Participant p,@PathVariable("id")Long id)
	{
		return pr.saveAndFlush(p);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/participant/{id}",method=RequestMethod.DELETE)
	public void supprimerParticipant(@PathVariable("id")Long id)
	{
		pr.delete(id);
	}
}
