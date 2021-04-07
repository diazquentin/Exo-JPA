package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import galerie.entity.Exposition;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {

}
