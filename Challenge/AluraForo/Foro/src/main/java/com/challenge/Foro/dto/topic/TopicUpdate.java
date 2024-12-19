package com.challenge.Foro.dto.topic;

import com.challenge.Foro.entity.Course;
import com.challenge.Foro.entity.Status;
import jakarta.validation.constraints.NotNull;

public record TopicUpdate(
        @NotNull Long id,
        String title,
        Course course,
        String message,
        Status status) {
}
