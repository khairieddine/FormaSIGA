package fr.siga.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.resources.MenuCompte;
import fr.siga.resources.MenuItemCompte;

@RestController
public class CompteService 
{
	@RequestMapping(value="infos",method=RequestMethod.GET)
	public Map<String,Object> getLogedUser(HttpSession session)
	{/*
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
	*/
		return null;
	}
	
	@RequestMapping(value="menu",method=RequestMethod.GET)
	public Map<String,Object> getCompte(HttpSession session)
	{	/*	
		SecurityContext sc = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username = sc.getAuthentication().getName();
		List<String>roles = new ArrayList<>();
		for(GrantedAuthority ga:sc.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		
		for(String i:roles)
		{
			if(i.equals("ROLE_ADMIN"))
			{
				
			}
		}
		*/
		Map<String,Object> params =new HashMap<>();
		//params.put("username",username);
		params.put("avatar","");
		//params.put("roles",roles);
		params.put("menu",MenuCompte.getMenuAdmin());
		return params;
	}
}
