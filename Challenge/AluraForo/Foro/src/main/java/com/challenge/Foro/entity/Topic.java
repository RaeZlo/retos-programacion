package com.challenge.Foro.entity;

import com.challenge.Foro.dto.topic.TopicRequest;
import com.challenge.Foro.dto.topic.TopicUpdate;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Table(name = "topics")
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Course course;
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    @Column(name="fecha_creacion", updatable = false)
    private LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name="ultima_actualizacion")
    private LocalDateTime updateDate;

    public Topic() {
    }

    public Topic(TopicRequest topicRequest) {
        this.title = topicRequest.title();
        this.course = topicRequest.course();
        this.message = topicRequest.message();
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
        this.status = Status.ACTIVO;
    }

    public void update(TopicUpdate topicUpdate) {
        if (topicUpdate.title() != null) {
            this.title = topicUpdate.title();
        }
        if (topicUpdate.course() != null) {
            this.course = topicUpdate.course();
        }
        if (topicUpdate.message() != null) {
            this.message = topicUpdate.message();
        }
        this.updateDate = LocalDateTime.now();
    }

    public void logicalDelete() {
        this.status = Status.ELIMINADO;
    }


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Course getCourse() {return course;}

    public void setCourse(Course course) {this.course = course;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public LocalDateTime getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}

    public LocalDateTime getUpdateDate() {return updateDate;}

    public void setUpdateDate(LocalDateTime updateDate) {this.updateDate = updateDate;}

    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}

    /*public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}*/
}