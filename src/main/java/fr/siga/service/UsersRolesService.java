package fr.siga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.RolesRepository;
import fr.siga.dao.UsersRepository;
import fr.siga.entites.Roles;
import fr.siga.entites.Users;

@RestController
public class UsersRolesService 
{
	@Autowired
	private UsersRepository ur;
	@Autowired
	private RolesRepository rr;
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="listeUsers",method=RequestMethod.GET)
	public List<Users> listesUsers()
	{
		return ur.findAll();
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="ajouterUser",method=RequestMethod.POST)
	public Users ajouterUser(@RequestBody Users e)
	{
		return ur.save(e);
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="listeRoles",method=RequestMethod.GET)
	public List<Roles> listesRoles()
	{
		return rr.findAll();
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="ajouterRole",method=RequestMethod.POST)
	public Roles ajouterRole(@RequestBody Roles r)
	{
		return rr.save(r);
	}
	
	//@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="ajouterRoleAUser",method=RequestMethod.POST)
	public void ajouterRoleAUser(Long username,String role)
	{
		Users ui = ur.getOne(username);
		Roles ri = rr.getOne(role);
		ui.getRoles().add(ri);
		ur.save(ui);
	}
}
