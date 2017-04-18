package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	private float difficulte;
	
	@OneToOne
	private Theme theme;
	
	@OneToMany
	private Collection<Suggestion> suggestions ;
	
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
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Collection<Suggestion> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(Collection<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	
	
	
}
