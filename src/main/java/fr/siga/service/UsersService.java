package fr.siga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.siga.dao.UsersRepository;
import fr.siga.entites.Users;


public class UsersService 
{
	@Autowired
	private UsersRepository r;
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="listesUsers",method=RequestMethod.GET)
	public List<Users> listesRoles()
	{
		return r.findAll();
	}
}
