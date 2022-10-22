package leang.repositories;

import leang.entities.TaskType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

}
