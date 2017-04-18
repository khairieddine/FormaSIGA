package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etablissement implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	  
	private String nom;
	private String adresse;
	private String ville;
	private int tele;
	private String fax;
	private String email;
	private String siteWeb;
	
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
	public String getAdresse() 
	{
		return adresse;
	}
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	public String getVille() 
	{
		return ville;
	}
	public void setVille(String ville) 
	{
		this.ville = ville;
	}
	public int getTele() 
	{
		return tele;
	}
	public void setTele(int tele) 
	{
		this.tele = tele;
	}
	public String getFax() 
	{
		return fax;
	}
	public void setFax(String fax) 
	{
		this.fax = fax;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getSiteWeb() 
	{
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) 
	{
		this.siteWeb = siteWeb;
	}
}