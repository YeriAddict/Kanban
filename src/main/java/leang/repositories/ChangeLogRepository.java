package leang.repositories;

import leang.entities.ChangeLog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long>{

}
