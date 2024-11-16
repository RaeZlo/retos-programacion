package com.Challenge.AluraGutendex.Repository;

import com.Challenge.AluraGutendex.Model.Book;
import com.Challenge.AluraGutendex.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);

    List<Book> findByLanguage(Language language);
}