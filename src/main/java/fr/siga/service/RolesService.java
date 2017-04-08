package fr.siga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import fr.siga.dao.RolesRepository;
import fr.siga.entites.Roles;


@RestController
public class RolesService 
{
	@Autowired
	private RolesRepository r;
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="listesRoles",method=RequestMethod.GET)
	public List<Roles> listesRoles()
	{
		return r.findAll();
	}
}
