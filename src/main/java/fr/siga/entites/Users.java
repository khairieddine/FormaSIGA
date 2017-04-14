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
import javax.persistence.Table;

import org.apache.wss4j.common.crypto.PasswordEncryptor;


@Entity
@Table(name="users")
public class Users implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long username;
	private String password;
	private Boolean active;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles = new ArrayList<Roles>();
	
	@OneToOne
	@JoinColumn(name="ID_USER_EMPLOYE")
	private Employe employe;
	
	public Users() 
	{
		super();
	}
	public Users(Long username, String password, Boolean active) 
	{
		super();
		this.username = username;
		this.password = password;
		this.active = active;
	}
	public Long getUsername() 
	{
		return username;
	}
	public void setUsername(Long username) 
	{
		this.username = username;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public Collection<Roles> getRoles() 
	{
		return roles;
	}
	public void setRoles(Collection<Roles> roles) 
	{
		this.roles = roles;
	}
	public Boolean getActive() 
	{
		return active;
	}
	public void setActive(Boolean active) 
	{
		this.active = active;
	}
	public Employe getEmploye() 
	{
		return employe;
	}
	public void setEmploye(Employe employe) 
	{
		this.employe = employe;
	}
	public String getPassword() // supprimer ça
	{
		return password;
	}
	
}
