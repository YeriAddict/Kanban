package leang.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leang.main.entities.TaskStatus;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long>{

}
