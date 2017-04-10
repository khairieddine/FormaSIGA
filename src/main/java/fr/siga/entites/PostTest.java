package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POST_TEST")
public class PostTest extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Date date;
	

	public PostTest() 
	{
		super();
	}

	public PostTest(Theme theme, Collection<Question> questions, float score) 
	{
		super(theme, questions, score);
	}

	public PostTest(Theme theme, Collection<Question> questions, float score, Date date) 
	{
		super(theme, questions, score);
		this.date = date;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}
}
