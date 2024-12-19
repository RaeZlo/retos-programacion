package com.challenge.Foro.controller;

import com.challenge.Foro.dto.topic.TopicRequest;
import com.challenge.Foro.dto.topic.TopicResponse;
import com.challenge.Foro.dto.topic.TopicUpdate;
import com.challenge.Foro.entity.Status;
import com.challenge.Foro.entity.Topic;
import com.challenge.Foro.repository.ITopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired // No es recomendable porque entorpece el testing. Utilizable para fines didacticos.
    private ITopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<TopicResponse> createTopic(@RequestBody @Valid TopicRequest topicRequest, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(topicRequest));
        TopicResponse topicResponse = new TopicResponse(topic.getId(), topic.getTitle(), topic.getMessage(),
                topic.getCourse(), topic.getCreationDate(), topic.getUpdateDate(), topic.getStatus());

        URI uri = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(topicResponse);

    }

    @GetMapping("/all")
    public ResponseEntity<Page<TopicResponse>> allTopic(@PageableDefault(size = 10, sort = {"updateDate"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findAllByStatusIn(List.of(Status.ACTIVO, Status.RESPONDIDO), pageable).map(TopicResponse::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> topicById(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        var response = new TopicResponse(topic.getId(), topic.getTitle(), topic.getMessage(),
                topic.getCourse(), topic.getCreationDate(), topic.getUpdateDate(), topic.getStatus());

        return ResponseEntity.ok(response);

        // Agregar despues una forma de evitar acceder a los topicos eliminados
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> updateTopic(@RequestBody @Valid TopicUpdate topicUpdate) {
        Topic topic = topicRepository.getReferenceById(topicUpdate.id());
        topic.update(topicUpdate);
        return ResponseEntity.ok(new TopicResponse(topic.getId(), topic.getTitle(), topic.getMessage(),
                topic.getCourse(), topic.getCreationDate(), topic.getUpdateDate(), topic.getStatus()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deletetopic(@PathVariable Long id) {
        // Eliminacion logica
        Topic topic = topicRepository.getReferenceById(id);
        topic.logicalDelete();

        /* Eliminacion de base de datos
        topicRepository.deleteById(id);*/
        return ResponseEntity.noContent().build();
    }
}
