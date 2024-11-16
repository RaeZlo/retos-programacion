package com.Challenge.AluraGutendex.Service;

import com.Challenge.AluraGutendex.Model.Author;
import com.Challenge.AluraGutendex.Repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private IAuthorRepository repository;

    public void saveAuthor(Author author) {
        repository.save(author);
    }

    public void deleteAuthor(Author author) {
        repository.delete(author);
    }

    public void updateAuthor(Author author) {
        repository.save(author);
    }

    public Author getAuthorByName(String name) {
        return repository.findByName(name);
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public List<Author> getAuthorsByPeriodPastDate(int year) {
        return repository.findAuthorsWithAge(year);
    }
}