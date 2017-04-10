package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theme implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private String description;
	
	public Theme() 
	{
		super();
	}

	public Theme(String nom, String description) 
	{
		super();
		this.nom = nom;
		this.description = description;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
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
