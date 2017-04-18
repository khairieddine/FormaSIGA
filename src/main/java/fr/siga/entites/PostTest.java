package fr.siga.entites;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POST_TEST")
public class PostTest extends Test implements Serializable
{
	private static final long serialVersionUID = 1L;

}
