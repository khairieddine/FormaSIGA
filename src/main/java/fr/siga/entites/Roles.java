package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String role;
	private String description;
	
	public Roles() 
	{
		super();
	}
	public Roles(String role, String description) 
	{
		super();
		this.role = role;
		this.description = description;
	}
	public String getNom() 
	{
		return role;
	}
	public void setNom(String role) 
	{
		this.role = role;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
}
