
package com.taskmanager.api.Service;

import java.util.List;
import com.taskmanager.api.ML.Task;

public interface TaskService {
    
    List<Task> getAll();

    Task getById(int id);

    Task save(Task task);

    Task update(int id, Task task);

    void delete(int id);
    
}
