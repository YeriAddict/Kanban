package leang.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leang.main.entities.ChangeLog;

@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long>{

}
