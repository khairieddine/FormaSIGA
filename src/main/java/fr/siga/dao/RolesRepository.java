package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.siga.entites.Roles;

public interface RolesRepository extends JpaRepository<Roles,String>
{

}
