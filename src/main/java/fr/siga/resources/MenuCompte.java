package fr.siga.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuCompte implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static List<MenuItemCompte> menuAdmin = new ArrayList<MenuItemCompte>();
	private static List<MenuItemCompte> menuChef = new ArrayList<MenuItemCompte>();
	private static List<MenuItemCompte> menuResponsable = new ArrayList<MenuItemCompte>();
	private static List<MenuItemCompte> menuEmploye = new ArrayList<MenuItemCompte>();
	
	static
	{
		List<MenuItemCompte> sousMenuAdmin = new ArrayList<MenuItemCompte>();
		
		sousMenuAdmin.add(new MenuItemCompte("fa fa-circle-o","#item1","sous menu admin 1",null));
		sousMenuAdmin.add(new MenuItemCompte("fa fa-circle-o","#item2","sous menu admin 2",null));
		sousMenuAdmin.add(new MenuItemCompte("fa fa-circle-o","#item3","sous menu admin 3",null));
		sousMenuAdmin.add(new MenuItemCompte("fa fa-circle-o","#item4","sous menu admin 4",null));
		
		MenuItemCompte menuAdmin1 = new MenuItemCompte("fa fa-newspaper-o","#","menu admin 1",sousMenuAdmin);
		MenuItemCompte menuAdmin2 = new MenuItemCompte("fa fa-newspaper-o","#","menu admin 2",null);
		MenuItemCompte menuAdmin3 = new MenuItemCompte("fa fa-newspaper-o","#","menu admin 3",sousMenuAdmin);
		MenuItemCompte menuAdmin4 = new MenuItemCompte("fa fa-newspaper-o","#","menu admin 4",sousMenuAdmin);
		
		menuEmploye.add(menuAdmin1);
		menuEmploye.add(menuAdmin2);
		menuEmploye.add(menuAdmin3);
		menuEmploye.add(menuAdmin4);
	}

	public static List<MenuItemCompte> getMenuAdmin() 
	{
		return menuAdmin;
	}

	public static List<MenuItemCompte> getMenuChef() 
	{
		return menuChef;
	}

	public static List<MenuItemCompte> getMenuResponsable() 
	{
		return menuResponsable;
	}

	public static List<MenuItemCompte> getMenuEmploye() 
	{
		return menuEmploye;
	}
}
