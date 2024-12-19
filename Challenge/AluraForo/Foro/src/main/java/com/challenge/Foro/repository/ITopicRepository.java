package com.challenge.Foro.repository;

import com.challenge.Foro.entity.Status;
import com.challenge.Foro.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findAllByStatusIn(List<Status> status, Pageable pageable);

}