package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.siga.entites.Users;

public interface UsersRepository extends JpaRepository<Users,Long>
{

}
