package fr.siga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.RoleRepository;
import fr.siga.dao.UtilisateurRepository;
import fr.siga.entites.Role;
import fr.siga.entites.Utilisateur;

@RestController
public class UtilisateurRoleService 
{
	@Autowired
	private UtilisateurRepository ur;
	@Autowired
	private RoleRepository rr;
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="utilisateur",method=RequestMethod.GET)
	public List<Utilisateur> listeUtilisateurs()
	{
		return ur.findAll();
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="utilisateur",method=RequestMethod.POST)
	public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur u)
	{
		return ur.save(u);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="role",method=RequestMethod.GET)
	public List<Role> listesRoles()
	{
		return rr.findAll();
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="role",method=RequestMethod.POST)
	public Role ajouterRole(@RequestBody Role r)
	{
		return rr.save(r);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="ajouterRoleAUtilisateur",method=RequestMethod.POST)
	public void ajouterRoleAUtilisateur(@RequestParam String identifiant,@RequestParam String role)
	{
		Optional<Utilisateur> ui = ur.findOne(identifiant);
		Optional<Role> ri = rr.findOne(role);
		
		/*
		System.out.println("-------------------- Utilisateur --------------------");
		System.out.println(ui.get().getIdentifiant());
		System.out.println(ui.get().getMotDePasse());
		System.out.println(ui.get().getActive());
		System.out.println(ui.get().getRoles());
		System.out.println("-------------------- Role --------------------");
		System.out.println(ri.get().getRole());
		System.out.println(ri.get().getDescription());
		*/
		ui.get().getRoles().add(ri.get());
		ur.save(ui.get());
	}
}
