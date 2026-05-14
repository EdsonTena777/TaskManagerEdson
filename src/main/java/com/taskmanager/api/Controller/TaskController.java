
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    private final TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    
    
    @Operation(summary = "Crear una nueva tarea")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Tarea creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping
    public ResponseEntity<Task> save(@Valid @RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }
    
    @Operation(summary = "Obtener todas las tareas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida correctamente")
    })
    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }
    
    @Operation(summary = "Obtener una tarea por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tarea encontrada"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> getbyId(@PathVariable int id){
        return ResponseEntity.ok(taskService.getById(id));
    }
    
    @Operation(summary = "Actualizar una tarea existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tarea actualizada correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable int id, @Valid @RequestBody Task task){
        return ResponseEntity.ok(taskService.update(id, task));
    }
    
    @Operation(summary = "Eliminar una tarea")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Tarea eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
