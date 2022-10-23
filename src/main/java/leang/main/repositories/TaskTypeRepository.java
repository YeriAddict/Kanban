package leang.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leang.main.entities.TaskType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

}
