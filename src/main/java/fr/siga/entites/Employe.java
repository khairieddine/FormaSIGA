package fr.siga.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private byte age;
	private Date dateNaissance;
	private String lieuNaissance;
	private String sex;
	private boolean estMarie;
	private String photo;
	private String adresse;
	private int tele;
	private String email;
	private Employe directeurEmploye;
	private String compteBanquaire;
	private String poste;
	
	public Employe() 
	{
		super();
	}

	public Employe(String cin, String nom, String prenom, byte age, Date dateNaissance, String lieuNaissance,
			String sex, boolean estMarie, String photo, String adresse, int tele, String email,
			Employe directeurEmploye, String compteBanquaire, String poste) 
	{
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.sex = sex;
		this.estMarie = estMarie;
		this.photo = photo;
		this.adresse = adresse;
		this.tele = tele;
		this.email = email;
		this.directeurEmploye = directeurEmploye;
		this.compteBanquaire = compteBanquaire;
		this.poste = poste;
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
	public boolean isEstMarie() {
		return estMarie;
	}
	public void setEstMarie(boolean estMarie) {
		this.estMarie = estMarie;
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
	public Employe getDirecteurEmploye() {
		return directeurEmploye;
	}
	public void setDirecteurEmploye(Employe directeurEmploye) {
		this.directeurEmploye = directeurEmploye;
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
}
