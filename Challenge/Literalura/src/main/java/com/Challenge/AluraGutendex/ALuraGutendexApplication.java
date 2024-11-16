package com.Challenge.AluraGutendex;

import com.Challenge.AluraGutendex.Service.AuthorService;
import com.Challenge.AluraGutendex.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ALuraGutendexApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(ALuraGutendexApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(bookService, authorService);

		main.menu();
	}
}
