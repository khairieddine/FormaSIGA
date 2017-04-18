package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Formation;

public interface FormationRepository extends JpaRepository<Formation,Long>
{

}
