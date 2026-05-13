
package com.taskmanager.api.Service;

import com.taskmanager.api.Repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.taskmanager.api.ML.Task;
import com.taskmanager.api.ML.TaskStatus;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    
    private final TaskRepository taskRepository;

    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    @Transactional
    @Override
    public List<Task> getAll(){
        return taskRepository.findAll();
    }
    
    @Transactional
    @Override
    public Task save(Task task){

        task.setCreationDate(LocalDateTime.now());

        if(task.getStatus()==null){
            task.setStatus(TaskStatus.PENDING);
        }

        return taskRepository.save(task);
    }
    
    @Transactional
    @Override
    public Task getById(int id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));
    }
    
    @Transactional
    @Override
    public Task update(int id, Task task) {

        Task taskDB = getById(id);

        taskDB.setTitle(task.getTitle());
        taskDB.setDescription(task.getDescription());
        taskDB.setStatus(task.getStatus());

        return taskRepository.save(taskDB);
    }

    @Transactional
    @Override
    public void delete(int id){

        Task task = getById(id);

        taskRepository.delete(task);
    }
}
