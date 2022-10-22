package leang.repositories;

import leang.entities.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long>{

}
