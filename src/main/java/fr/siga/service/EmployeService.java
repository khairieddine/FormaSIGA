package fr.siga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="employe/listesEmployes",method=RequestMethod.GET)
	public List<Employe> listesEmployes()
	{
		return e.findAll();
	}
}
