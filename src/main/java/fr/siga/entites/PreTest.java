package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRE_TEST")
public class PreTest extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;

}
