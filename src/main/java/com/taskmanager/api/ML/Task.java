
package com.taskmanager.api.ML;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede superar 100 caracteres")
    @Column(name = "Title", nullable = false, length = 100)
    private String title;
    @Size(max = 500, message = "La descripción no puede superar 500 caracteres")
    @Column(name = "Description", nullable = true, length = 500)
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    @Column(name = "Status", nullable = false, length = 20)
    private TaskStatus status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate;
    
    public Task(){
    
    }
    
    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now();

        if (this.status == null) {
            this.status = TaskStatus.PENDING;
        }
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    
    
}
