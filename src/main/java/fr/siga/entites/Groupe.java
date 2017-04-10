package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;

	public Groupe() 
	{
		super();
	}

	public Groupe(String nom, Collection<Employe> employes) 
	{
		super();
		this.nom = nom;
		this.employes = employes;
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

	public Collection<Employe> getEmployes() 
	{
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) 
	{
		this.employes = employes;
	}
}
