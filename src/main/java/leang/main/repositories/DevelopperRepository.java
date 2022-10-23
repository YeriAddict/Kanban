package leang.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leang.main.entities.Developper;

@Repository
public interface DevelopperRepository extends JpaRepository<Developper, Long>{
    
}
