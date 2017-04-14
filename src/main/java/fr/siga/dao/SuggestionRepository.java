package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion,Long>
{

}
