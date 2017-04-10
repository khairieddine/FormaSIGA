package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_TEST",discriminatorType=DiscriminatorType.STRING,length=15)
public abstract class Test implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_TEST_THEME")
	private Theme theme;
	
	@ManyToMany
	@JoinTable(name="QUESTIONS_TESTS")
	private Collection<Question> questions;
	private float score;
	
	public Test() 
	{
		super();
	}

	public Test(Theme theme, Collection<Question> questions, float score) 
	{
		super();
		this.theme = theme;
		this.questions = questions;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}