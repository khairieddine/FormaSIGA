package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Long>
{

}
