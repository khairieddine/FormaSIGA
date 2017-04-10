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
	
	private String nom;
	private String prenom;
	private String sex;
	private String etatCivile;
	private byte age;
	private Date dateNaissance;
	private String lieuNaissance;
	
	
	private String photo;
	private String adresse;
	private int tele;
	
	
	private String compteBanquaire;
	private String poste;
	
	@ManyToOne
	@JoinColumn(name="ID_DIRECTEUR_EMPLOYE")
	private Employe directeurEmploye;
	
	@ManyToMany
	@JoinTable(name="EMPLOYES_GROUPES")
	private Collection<Groupe> groupes;
	
	public Employe() 
	{
		super();
	}

	public Employe(String cin, String nom, String prenom, byte age, Date dateNaissance, String lieuNaissance,
			String sex, String etatCivile, String photo, String adresse, int tele, String email, String compteBanquaire,
			String poste, Employe directeurEmploye, Collection<Groupe> groupes) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sex = sex;
		this.etatCivile = etatCivile;
		this.photo = photo;
		this.adresse = adresse;
		this.tele = tele;
		this.email = email;
		this.compteBanquaire = compteBanquaire;
		this.poste = poste;
		this.directeurEmploye = directeurEmploye;
		this.groupes = groupes;
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
