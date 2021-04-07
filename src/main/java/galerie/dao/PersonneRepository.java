package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{
    
}
