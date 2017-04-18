package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEST_A_FROID")
public class TestAFroid  extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;

}
