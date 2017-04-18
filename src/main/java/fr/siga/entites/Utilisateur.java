package fr.siga.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String identifiant;
	private String motDePasse;
	private Boolean active;
	
	@ManyToMany
	@JoinTable(name="UTILISATEURS_ROLES")
	private Collection<Role> roles = new ArrayList<Role>();
	
	@OneToOne
	@JoinColumn(name="ID_EMPLOYE")
	private Employe employe;

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
}