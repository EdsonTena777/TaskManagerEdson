
package com.taskmanager.api.Controller;

import com.taskmanager.api.Service.TaskService;
import com.taskmanager.api.ML.Task;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private final TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    
    @PostMapping
    public ResponseEntity<Task> save(@Valid @RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }
    
    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> getbyId(@PathVariable int id){
        return ResponseEntity.ok(taskService.getById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable int id, @Valid @RequestBody Task task){
        return ResponseEntity.ok(taskService.update(id, task));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
