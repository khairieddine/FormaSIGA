package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,String>
{

}
