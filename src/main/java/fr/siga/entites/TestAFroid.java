package fr.siga.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEST_A_FROID")
public class TestAFroid  extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;

	public TestAFroid() 
	{
		super();
	}

	public TestAFroid(Theme theme, float score) 
	{
		super(theme, score);
	}	
}
