package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Participant;

public interface ParticipantRepository extends JpaRepository< Participant,Long>
{

}
