package com.Challenge.AluraGutendex.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private int downloadCount;
    @Enumerated(EnumType.STRING)
    private Language language;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(DataBook b) {
        this.title = b.title();
        this.downloadCount = b.downloadCount();
        if (!b.languages().isEmpty()) {
            this.language = Language.fromString(b.languages().get(0));
        } else {
            throw new IllegalArgumentException("No se proporciono un idioma válido!!!");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCounts(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }


    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    @Override
    public String toString() {
        return """
                ------------LIBRO--------------
                Titulo: %s
                Id: %s
                Autores: %s
                Descargas: %s
                Lenguajes: %s
                --------------------------------
                """.formatted(title, id, authors, downloadCount, language);
    }
}