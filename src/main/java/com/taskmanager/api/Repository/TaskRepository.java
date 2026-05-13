
package com.taskmanager.api.Repository;

import com.taskmanager.api.ML.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
