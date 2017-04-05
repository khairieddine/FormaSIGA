package fr.siga.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.EmployeRepository;
import fr.siga.entites.Employe;

@RestController
public class EmployeService 
{
	@Autowired
	private EmployeRepository e;
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="employe/listesEmployes",method=RequestMethod.GET)
	public List<Employe> listesEmployes()
	{
		return e.findAll();
	}
	
	@RequestMapping(value="infos",method=RequestMethod.GET)
	public Map<String,Object> getLogedUser(HttpSession session)
	{
		SecurityContext sc = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username = sc.getAuthentication().getName();
		List<String>roles = new ArrayList<>();
		for(GrantedAuthority ga:sc.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		
		Map<String,Object> params =new HashMap<>();
		params.put("username",username);
		params.put("roles",roles);
		
		return params;
		
	}
}
