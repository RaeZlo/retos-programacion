package com.Challenge.AluraGutendex.Repository;

import com.Challenge.AluraGutendex.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {
    public Author findByName(String name);

    @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND (a.deathYear > :year OR a.deathYear IS NULL)")
    List<Author> findAuthorsWithAge(@Param("year") int year);
}