package fr.siga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.siga.entites.Theme;

public interface ThemeRepository extends JpaRepository<Theme,Long>
{

}
