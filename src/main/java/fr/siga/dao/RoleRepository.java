package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.siga.entites.Role;

public interface RoleRepository extends JpaRepository<Role,String>
{

}
