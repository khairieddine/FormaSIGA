package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRE_TEST")
public class PreTest extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Date date;

	public PreTest() 
	{
		super();
	}

	public PreTest(Theme theme, float score) 
	{
		super(theme, score);

	}

	public PreTest(Theme theme, Collection<Question> questions, float score, Date date) 
	{
		super(theme, score);
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
