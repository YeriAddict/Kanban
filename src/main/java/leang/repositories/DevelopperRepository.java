package leang.repositories;

import leang.entities.Developper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopperRepository extends JpaRepository<Developper, Long>{
    
}