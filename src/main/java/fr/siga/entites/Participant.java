package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Participant implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String etatValidation; //ACCORDE ATTENTE REFUS
	private String convention;
	
	@OneToOne
	private Employe employe;
	@OneToOne 
	private  PreTest preTest;
	@OneToOne
	private PostTest postTest;
	@OneToOne
	private TestAFroid testAFroid;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEtatValidation() {
		return etatValidation;
	}
	public void setEtatValidation(String etatValidation) {
		this.etatValidation = etatValidation;
	}
	public String getConvention() {
		return convention;
	}
	public void setConvention(String convention) {
		this.convention = convention;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public PreTest getPreTest() {
		return preTest;
	}
	public void setPreTest(PreTest preTest) {
		this.preTest = preTest;
	}
	public PostTest getPostTest() {
		return postTest;
	}
	public void setPostTest(PostTest postTest) {
		this.postTest = postTest;
	}
	public TestAFroid getTestAFroid() {
		return testAFroid;
	}
	public void setTestAFroid(TestAFroid testAFroid) {
		this.testAFroid = testAFroid;
	}
}