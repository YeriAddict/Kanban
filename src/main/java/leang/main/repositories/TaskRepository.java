package leang.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import leang.main.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
