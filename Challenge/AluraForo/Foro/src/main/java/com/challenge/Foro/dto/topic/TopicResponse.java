package com.challenge.Foro.dto.topic;

import com.challenge.Foro.entity.Course;
import com.challenge.Foro.entity.Status;
import com.challenge.Foro.entity.Topic;
import java.time.LocalDateTime;

public record TopicResponse(
        Long id,
        String title,
        String message,
        Course course,
        LocalDateTime creationDate,
        LocalDateTime updateDate,
        Status status) {

    public TopicResponse(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCourse(),
                topic.getCreationDate(),
                topic.getUpdateDate(),
                topic.getStatus());
    }
}

