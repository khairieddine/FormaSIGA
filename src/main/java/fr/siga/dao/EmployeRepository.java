package fr.siga.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.siga.entites.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long>
{
	@Query("SELECT e FROM Employe e WHERE e.nom like :x")
	public Page<Employe> chercherEmployePage(@Param("x") String mc,Pageable pageable);
	
	@Query("SELECT e FROM Employe e WHERE e.nom like :x")
	public List<Employe> chercherEmploye(@Param("x") String mc);
}
