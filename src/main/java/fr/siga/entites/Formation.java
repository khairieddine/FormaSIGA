package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Formation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private float budget;
	private byte volumeHoraire;
	private String horaire;
	private byte  nombrePlaces;
	
	@OneToOne
	private Theme theme;
	@OneToOne
	private Etablissement etablissement;
	@OneToMany
	private Collection<Participant> participants;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public Date getDateDebut() 
	{
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) 
	{
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() 
	{
		return dateFin;
	}
	public void setDateFin(Date dateFin) 
	{
		this.dateFin = dateFin;
	}
	
	public float getBudget() 
	{
		return budget;
	}
	public void setBudget(float budget) 
	{
		this.budget = budget;
	}
	
	public byte getVolumeHoraire() 
	{
		return volumeHoraire;
	}
	public void setVolumeHoraire(byte volumeHoraire) 
	{
		this.volumeHoraire = volumeHoraire;
	}
	public String getHoraire() 
	{
		return horaire;
	}
	public void setHoraire(String horaire) 
	{
		this.horaire = horaire;
	}
	public byte getNombrePlaces() 
	{
		return nombrePlaces;
	}
	public void setNombrePlaces(byte nombrePlaces) 
	{
		this.nombrePlaces = nombrePlaces;
	}
	public Theme getTheme() 
	{
		return theme;
	}
	public void setTheme(Theme theme) 
	{
		this.theme = theme;
	}
	public Collection<Participant> getParticipants() 
	{
		return participants;
	}
	public void setParticipants(Collection<Participant> participants) 
	{
		this.participants = participants;
	}
	public Etablissement getEtablissement() 
	{
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) 
	{
		this.etablissement = etablissement;
	}	
}