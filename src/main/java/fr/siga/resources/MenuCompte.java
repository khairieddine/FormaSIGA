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
		List<MenuItemCompte> sousMenuInformations = new ArrayList<MenuItemCompte>();
		sousMenuInformations.add(new MenuItemCompte("fa fa-circle-o","listeEmployesInformations","Aperçu des employes",null));
		sousMenuInformations.add(new MenuItemCompte("fa fa-circle-o","statistiquesInformations","Statistiques",null));
		
		List<MenuItemCompte> sousMenuEtablissements = new ArrayList<MenuItemCompte>();
		sousMenuEtablissements.add(new MenuItemCompte("fa fa-circle-o","listeEtablissements","Liste des établissements",null));
		sousMenuEtablissements.add(new MenuItemCompte("fa fa-circle-o","ajouterEtablissement","Ajouter un établissement",null));
		sousMenuEtablissements.add(new MenuItemCompte("fa fa-circle-o","gererEtablissements","Gérer les établissements",null));
		
		List<MenuItemCompte> sousMenuFormations = new ArrayList<MenuItemCompte>();
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","listeFormations","Liste des formations",null));
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","listeParticipants","Liste des participants",null));
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","nouvelleFormation","Nouvelle formation",null));
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","gererFormations","Gérer les formations",null));;
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","planifierDates","Planifier les dates",null));
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","envoiConvocations","Envoi les convocations",null));
		sousMenuFormations.add(new MenuItemCompte("fa fa-circle-o","parametreFormation"," Paramètre",null));
		
		List<MenuItemCompte> sousMenuThemes = new ArrayList<MenuItemCompte>();
		sousMenuThemes.add(new MenuItemCompte("fa fa-circle-o","listeThemes","Liste des thémes",null));
		sousMenuThemes.add(new MenuItemCompte("fa fa-circle-o","nouveauTheme","Nouveau thémes",null));
		sousMenuThemes.add(new MenuItemCompte("fa fa-circle-o","gererThemes","Gérer les thémes",null));
		
		List<MenuItemCompte> sousMenuQuestions = new ArrayList<MenuItemCompte>();
		sousMenuQuestions.add(new MenuItemCompte("fa fa-circle-o","listeQuestions","Liste des questions",null));
		sousMenuQuestions.add(new MenuItemCompte("fa fa-circle-o","nouvelleQuestion","Nouvelle question",null));
		sousMenuQuestions.add(new MenuItemCompte("fa fa-circle-o","gererQuestions","Gérer les questions",null));
		sousMenuQuestions.add(new MenuItemCompte("fa fa-circle-o","resultatStatestiqueQestions","Resultat et statistique ",null));
		
		
		MenuItemCompte menuInformations = new MenuItemCompte("fa fa-eye","","Informations",sousMenuInformations);
		MenuItemCompte menuEtablissements = new MenuItemCompte("fa fa-building-o","","Établissement",sousMenuEtablissements);
		MenuItemCompte menuFormations = new MenuItemCompte("fa fa-tasks","","Formation",sousMenuFormations);
		MenuItemCompte menuThemes = new MenuItemCompte("fa fa-th-list","","Theme",sousMenuThemes);
		MenuItemCompte menuQuestions = new MenuItemCompte("fa fa-question-circle","","Question",sousMenuQuestions);
		
		menuResponsable.add(menuInformations);
		menuResponsable.add(menuEtablissements);
		menuResponsable.add(menuFormations);
		menuResponsable.add(menuThemes);
		menuResponsable.add(menuQuestions);
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
