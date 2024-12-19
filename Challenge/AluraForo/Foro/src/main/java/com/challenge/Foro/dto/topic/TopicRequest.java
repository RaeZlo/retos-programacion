package com.challenge.Foro.dto.topic;

import com.challenge.Foro.entity.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicRequest(
        @NotBlank
        String title,
        @NotNull
        Course course,
        @NotBlank
        String message) {
}
