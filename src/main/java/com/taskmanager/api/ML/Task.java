
package com.taskmanager.api.ML;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Title", nullable = false, length = 100)
    private String title;
    @Column(name = "Description", nullable = true, length = 500)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, length = 20)
    private TaskStatus status;
    @Column(name = "CreationDate", nullable = false)
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
