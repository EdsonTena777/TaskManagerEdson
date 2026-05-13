
package com.taskmanager.api.Service;

import java.util.List;
import com.taskmanager.api.ML.Task;

public interface TaskService {
    
    List<Task> getAll();

    Task getById(Integer id);

    Task save(Task task);

    Task update(Integer id, Task task);

    void delete(Integer id);
    
}
