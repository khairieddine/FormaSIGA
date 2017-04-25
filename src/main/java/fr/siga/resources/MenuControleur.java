package fr.siga.resources;

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
public class MenuControleur 
{
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
	
	@RequestMapping(value="menu",method=RequestMethod.GET)
	public Map<String,Object> getCompte(HttpSession session)
	{	
		SecurityContext sc = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		String username = sc.getAuthentication().getName();
		
		List<String>roles = new ArrayList<>();
		for(GrantedAuthority ga:sc.getAuthentication().getAuthorities())
		{
			roles.add(ga.getAuthority());
		}
		
		List<MenuItemCompte> menu = new ArrayList<MenuItemCompte>();
		
		
		for(String i:roles)
		{
			if(i.equals("ROLE_ADMIN"))
			{
				menu.addAll(MenuCompte.getMenuAdmin());
			}
			if(i.equals("ROLE_RESPONSABLE"))
			{
				menu.addAll(MenuCompte.getMenuResponsable());
			}
			if(i.equals("ROLE_CHEF"))
			{
				menu.addAll(MenuCompte.getMenuChef());
			}
			if(i.equals("ROLE_EMPLOYE"))
			{
				menu.addAll(MenuCompte.getMenuEmploye());
			}
		}

		Map<String,Object> params =new HashMap<>();
		params.put("identifiant",username);
		params.put("avatar","/images/user.jpg");
		params.put("roles",roles);
		params.put("menu",menu);
		return params;
	}
}
