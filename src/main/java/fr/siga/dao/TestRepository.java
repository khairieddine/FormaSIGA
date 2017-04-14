package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.siga.entites.Test;

public interface TestRepository extends JpaRepository<Test,Long>
{

}
