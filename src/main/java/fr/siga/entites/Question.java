package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Question implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	private float difficulte;
	private String reponseJuste;
	
	@ManyToOne
	@JoinColumn(name="ID_THEME")
	private Theme theme;
	
	@ManyToMany(mappedBy="questions")
	private Collection<Test> tests;

	public Question() 
	{
		super();
	}

	public Question(String question, float difficulte, String reponseJuste, Collection<Test> tests) 
	{
		super();
		this.question = question;
		this.difficulte = difficulte;
		this.reponseJuste = reponseJuste;
		this.tests = tests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public float getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(float difficulte) {
		this.difficulte = difficulte;
	}

	public String getReponseJuste() {
		return reponseJuste;
	}

	public void setReponseJuste(String reponseJuste) {
		this.reponseJuste = reponseJuste;
	}

	public Collection<Test> getTests() {
		return tests;
	}

	public void setTests(Collection<Test> tests) {
		this.tests = tests;
	}	
}
