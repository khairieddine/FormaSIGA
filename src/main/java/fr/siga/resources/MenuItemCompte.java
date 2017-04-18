package fr.siga.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuItemCompte  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String iconMenu;
	private String lienMenu;
	private String textMenu;
	List<MenuItemCompte> sousMenu = new ArrayList<MenuItemCompte>();
	
	public MenuItemCompte() 
	{
		super();
	}

	public MenuItemCompte(String iconMenu, String lienMenu, String textMenu, List<MenuItemCompte> sousMenu) 
	{
		super();
		this.iconMenu = iconMenu;
		this.lienMenu = lienMenu;
		this.textMenu = textMenu;
		this.sousMenu = sousMenu;
	}

	public String getIconMenu() 
	{
		return iconMenu;
	}

	public void setIconMenu(String iconMenu) 
	{
		this.iconMenu = iconMenu;
	}

	public String getLienMenu() 
	{
		return lienMenu;
	}

	public void setLienMenu(String lienMenu) 
	{
		this.lienMenu = lienMenu;
	}

	public String getTextMenu() 
	{
		return textMenu;
	}

	public void setTextMenu(String textMenu) 
	{
		this.textMenu = textMenu;
	}

	public List<MenuItemCompte> getSousMenu() 
	{
		return sousMenu;
	}

	public void setSousMenu(List<MenuItemCompte> sousMenu)
	{
		this.sousMenu = sousMenu;
	}
}
