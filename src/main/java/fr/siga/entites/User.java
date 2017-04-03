package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User implements Serializable
{
	@Id
	private String username;
	private String password;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles;
	
	public User() 
	{
		super();
	}
	public User(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
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
}
