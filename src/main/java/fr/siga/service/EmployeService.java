package fr.siga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.siga.dao.EmployeRepository;
import fr.siga.dao.RoleRepository;
import fr.siga.dao.UtilisateurRepository;
import fr.siga.entites.Employe;
import fr.siga.entites.Role;
import fr.siga.entites.Utilisateur;

@RestController
public class EmployeService 
{
	@Autowired
	private EmployeRepository er;
	@Autowired
	private UtilisateurRepository ur;
	@Autowired
	private RoleRepository rr;
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/employesPage",method=RequestMethod.GET)
	public Page<Employe> listesEmployesPage(@RequestParam(name="page",defaultValue="1")int page,@RequestParam(name="size",defaultValue="10")int size)
	{
		return er.findAll(new PageRequest(page, size));
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/employe",method=RequestMethod.GET)
	public List<Employe> listeEmployes()
	{
		return er.findAll();
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.GET)
	public Optional<Employe> employe(@PathVariable("id")Long id)
	{
		return er.findOne(id);
	}

	@RequestMapping(value="/inscrire",method=RequestMethod.POST)
	public Employe ajouterEmploye(@RequestBody Employe e)
	{
		Employe emp = er.save(e);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setIdentifiant(e.getIdentifiant());
		utilisateur.setMotDePasse(passwordEncoder.encode(e.getMotDePasse()));
		utilisateur.setActive(true);
		
		ur.save(utilisateur);
		
		Optional<Utilisateur> ui = ur.findOne(emp.getIdentifiant());
		Optional<Role> ri = rr.findOne("RESPONSABLE");
		
		ui.get().getRoles().add(ri.get());
		ui.get().setEmploye(emp);
		
		/*
		System.out.println("-------------------- Uers --------------------");
		System.out.println(ui.get().getIdentifiant());
		System.out.println(ui.get().getMotDePasse());
		System.out.println(ui.get().getActive());
		System.out.println(ui.get().getRoles());
		System.out.println("-------------------- Roles --------------------");
		System.out.println(ri.get().getRole());
		System.out.println(ri.get().getDescription());
		*/
		
		ur.save(ui.get());
		
		return emp;
	}

	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.PUT)
	public Employe modifierEmploye(@RequestBody Employe e,@PathVariable("id")Long id)
	{
		e.setId(id);
		return er.saveAndFlush(e);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF","ROLE_EMPLOYE"})
	@RequestMapping(value="/employe/{id}",method=RequestMethod.DELETE)
	public void supprimerEmploye(@PathVariable("id")Long id)
	{
		er.delete(id);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercherEmployePage",method=RequestMethod.GET)
	public Page<Employe> chercherEmployePage(@Param("x") String mc,@RequestParam(name="page",defaultValue="1")int page,@RequestParam(name="size",defaultValue="10")int size)
	{
		return er.chercherEmployePage("%"+mc+"%", new PageRequest(page, size));
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_RESPONSABLE","ROLE_CHEF"})
	@RequestMapping(value="/chercherEmploye",method=RequestMethod.GET)
	public List<Employe> chercherEmploye(@Param("x") String mc)
	{
		return er.chercherEmploye("%"+mc+"%");
	}
}
