package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employe implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String email;
	private String identifiant;
	private String motDePasse;
	
	private String nom;
	private String prenom;
	private String sex; //sexe
	private String etatCivile;
	private byte age;
	private Date dateNaissance;
	private String lieuNaissance;
	/*
	private String nationalite;
	private String lieuResidence;
	private String diplome;
	*/
	//private Collection<Theme> profession;
	
	
	private String photo;
	private String adresse;
	private int tele;
	
	
	private String compteBanquaire;
	private String poste;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYE_ID_DIRECTEUR")
	private Employe directeurEmploye;
	
	@ManyToMany
	@JoinTable(name="EMPLOYE_GROUPE")
	private Collection<Groupe> groupes;
	
	public Employe() 
	{
		super();
	}

	

	public Employe(String cin, String email, String identifiant, String motDePasse, String nom, String prenom, String sex,
			String etatCivile, byte age, Date dateNaissance, String lieuNaissance, String photo, String adresse,
			int tele, String compteBanquaire, String poste, Employe directeurEmploye) {
		super();
		this.cin = cin;
		this.email = email;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.sex = sex;
		this.etatCivile = etatCivile;
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.photo = photo;
		this.adresse = adresse;
		this.tele = tele;
		this.compteBanquaire = compteBanquaire;
		this.poste = poste;
		this.directeurEmploye = directeurEmploye;
	}

	public String getIdentifiant() 
	{
		return identifiant;
	}
	
	public void setIdentifiant(String identifiant) 
	{
		this.identifiant = identifiant;
	}
	
	public String getMotDePasse() 
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) 
	{
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEtatCivile() {
		return etatCivile;
	}

	public void setEtatCivile(String etatCivile) {
		this.etatCivile = etatCivile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTele() {
		return tele;
	}

	public void setTele(int tele) {
		this.tele = tele;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompteBanquaire() {
		return compteBanquaire;
	}

	public void setCompteBanquaire(String compteBanquaire) {
		this.compteBanquaire = compteBanquaire;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
	@JsonIgnore
	public Employe getDirecteurEmploye() {
		return directeurEmploye;
	}
	@JsonSetter
	public void setDirecteurEmploye(Employe directeurEmploye) {
		this.directeurEmploye = directeurEmploye;
	}
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	@JsonSetter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	
}
