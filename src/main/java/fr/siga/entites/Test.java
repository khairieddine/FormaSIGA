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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_TEST",discriminatorType=DiscriminatorType.STRING,length=15)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="typeTest")
@JsonSubTypes({
		@Type(name="PRE_TEST",value=PreTest.class),
		@Type(name="POST_TEST",value=PostTest.class),
		@Type(name="TEST_A_FROID",value=TestAFroid.class),
})

public abstract class Test implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private float score;
	
	@OneToOne
	private Theme theme;
	
	@ManyToMany
	@JoinTable(name="TEST_QUESTION")
	private Collection<Question> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	//@JsonIgnore
	public Theme getTheme() {
		return theme;
	}
	//@JsonSetter
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<Question> questions) {
		this.questions = questions;
	}
}
