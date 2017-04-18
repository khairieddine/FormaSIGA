package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe,Long>
{

}
