package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement,Long>
{

}
