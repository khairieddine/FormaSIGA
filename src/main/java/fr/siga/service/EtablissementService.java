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

import fr.siga.dao.EtablissementRepository;
import fr.siga.entites.Etablissement;

@RestController
public class EtablissementService 
{
	@Autowired
	private EtablissementRepository er;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/etablissement",method=RequestMethod.GET)
	public List<Etablissement> listeEtablissements() 
	{
		return er.findAll();
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.GET)
	public Optional<Etablissement> theme(@PathVariable("id")Long id) 
	{	
		return er.findOne(id);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/etablissement",method=RequestMethod.POST)
	public Etablissement ajoutetEtablissement(@RequestBody Etablissement e) 
	{
		return er.save(e);
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.PUT)
	public Etablissement modifierEtablissement(@RequestBody Etablissement e,@PathVariable("id")Long id)
	{
		return er.saveAndFlush(e);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/etablissement/{id}",method=RequestMethod.DELETE)
	public void supprimerEtablissement(@PathVariable("id")Long id)
	{
		er.delete(id);
	}
}