package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.siga.entites.Question;

public interface QuestionRepository extends JpaRepository<Question,Long>
{

}
