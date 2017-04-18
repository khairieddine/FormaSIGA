package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suggestion implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String suggestion;
	
	private boolean validite;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getSuggestion() 
	{
		return suggestion;
	}

	public void setSuggestion(String suggestion) 
	{
		this.suggestion = suggestion;
	}

	public boolean isValidite() 
	{
		return validite;
	}

	public void setValidite(boolean validite) 
	{
		this.validite = validite;
	}
}
