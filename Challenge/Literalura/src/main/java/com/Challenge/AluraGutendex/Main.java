package com.Challenge.AluraGutendex;

import com.Challenge.AluraGutendex.Model.*;
import com.Challenge.AluraGutendex.Service.AuthorService;
import com.Challenge.AluraGutendex.Service.BookService;
import com.Challenge.AluraGutendex.Service.ConsumeAPI;
import com.Challenge.AluraGutendex.Service.ConvertData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final ConsumeAPI consumeAPI = new ConsumeAPI();
    private static final ConvertData convertData = new ConvertData();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String URL_BASE = "http://gutendex.com/books/?";
    private static BookService bookService;
    private static AuthorService authorService;

    public Main(BookService bookService, AuthorService authorService) {
        Main.authorService = authorService;
        Main.bookService = bookService;
    }
    public void menu() {
        boolean encendido = true;

        while (encendido) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Elija la opción que desee: ");
            System.out.println();
            System.out.println("1) Buscar un libro por el titulo.");
            System.out.println("2) Listar los libros registrados en la base de datos.");
            System.out.println("3) Listar los autores registrados en la base de datos.");
            System.out.println("4) Listar los autores vivos en un determinado año.");
            System.out.println("5) Listar según su idioma.");
            System.out.println("6) Salir");
            System.out.println();
            System.out.println("Elige una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            System.out.println("------------------------------------------------------------------");

            switch (opcion) {
                case 1:
                    search();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    encendido = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void search() {
        System.out.println("Ingrese el titulo del libro que desea buscar: ");
        String title = scanner.nextLine();

        var search = consumeAPI.getData(URL_BASE+"?search="+title.replace(" ", "+"));
        Data searching = null;
        try {
            searching = convertData.getData(search, Data.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Optional<DataBook> bookSearched = searching.results().stream()
                .filter(b -> b.title().toUpperCase().contains(title.toUpperCase()))
                .findFirst();

        if (bookSearched.isPresent()) {
            DataBook bookDTO = bookSearched.get();
            System.out.println("El libro fue encontrado con exito!");
            Book book = new Book(bookDTO);

            Optional<Book> existingBook = Optional.ofNullable(bookService.getBookByTitle(bookDTO.title()));
            if (existingBook.isPresent()) {
                System.out.println("El libro ya existe en la base de datos.");
                book = existingBook.get();
                System.out.println(book);
            } else {
                for (DataAuthor authorData : bookDTO.authors()) {
                    Author author;
                    Optional<Author> existingAuthor = Optional.ofNullable(authorService.getAuthorByName(authorData.name()));
                    if (existingAuthor.isPresent()) {
                        author = existingAuthor.get();
                    } else {
                        author = new Author(authorData);
                        authorService.saveAuthor(author);
                    }
                    book.addAuthor(author);
                }
                bookService.saveBook(book);
                System.out.println("Libro guardado exitosamente");
                System.out.println(book);
            }
        } else {
            System.out.println("No se encontro ningun libro con ese nombre");
        }



    }

    private static void showAllRegisteredBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(System.out::println);
    }

    private static void showAllRegisteredAuthors() {
        List<Author> authors = authorService.getAllAuthors();


        authors.forEach(a -> System.out.printf(
                """
                        ------------AUTOR--------------
                        Id: %s
                        Nombre: %s
                        Año de Nacimiento: %s
                        Año de Fallecimiento: %s
                        --------------------------------
                        """.formatted(a.getId(), a.getName(), a.getBirthYear(), a.getDeathYear())
        ));


    }

    private static void showAllAuthorsByPeriodPastDate() {
        System.out.println("\nIngresa el año para filtrar autores");
        var year = scanner.nextInt();

        List<Author> authorInPeriod = authorService.getAuthorsByPeriodPastDate(year);
        if (!authorInPeriod.isEmpty()) {
            authorInPeriod.forEach(a -> System.out.printf(
                    """
                            ------------AUTOR--------------
                            Id: %s
                            Nombre: %s
                            Año de Nacimiento: %s
                            Año de Fallecimiento: %s
                            --------------------------------
                            """.formatted(a.getId(), a.getName(), a.getBirthYear(), a.getDeathYear())
            ));
        } else {
            System.out.println("No hay autores con ese periodo de tiempo");
        }
    }

    public static void filterBooksByLanguage() {

        System.out.println();
        System.out.println("""
                Ingresa el idioma para buscar los libros
                1. Español - es
                2. Ingles - en 
                3. Italiano - it
                4. Portugues - pt
                5. Ruso - ru
                """);
        var language = scanner.nextLine();

        Language languageEnum;
        try {
            languageEnum = Language.fromString(language.toLowerCase());

            if (languageEnum == null) {
                System.out.println("El idioma ingresado no es válido. Por favor, intenta de nuevo.");
                return;
            }

            List<Book> booksFiltered = bookService.getBooksFilteredByLanguage(languageEnum);
            if (!booksFiltered.isEmpty()) {

                System.out.println("La cantidad de libros filtrados son: " + booksFiltered.size());
                System.out.println("\nLos libro filtrados por el idioma " + languageEnum + " [" + languageEnum.getShortWord() + "]");
                booksFiltered.forEach(b -> System.out.printf(
                        """
                                ------------LIBRO--------------
                                Titulo: %s
                                Id: %s
                                Autores: %s
                                Descargas: %s
                                Lenguajes: %s
                                --------------------------------
                                """.formatted(b.getTitle(), b.getId(), b.getAuthors(), b.getLanguage(), b.getDownloadCount())
                ));
            } else {
                System.out.println("No hay libros con ese lenguaje");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    private static void showStatsFromBooks() {
        List<Book> books = bookService.getAllBooks();
        System.out.println("\nTop 10 libros más descargados");
        books.stream()
                .sorted(Comparator.comparing(Book::getDownloadCount).reversed())
                .limit(10)
                .forEach(b -> System.out.println(
                        "Cantidad descargas: " + b.getDownloadCount() +
                                ", Libro Id: " + b.getId() +
                                ", Nombre Libro: " + b.getTitle().toUpperCase() +
                                ", Autores: " + b.getAuthors()
                ));

        DoubleSummaryStatistics stats = books.stream()
                .filter(e -> e.getDownloadCount() > 0)
                .collect(Collectors.summarizingDouble(Book::getDownloadCount));

        System.out.println("\nEstadisticas de libros registrados \n");
        System.out.println("Media de Descargas: " + stats.getAverage());
        System.out.println("Libro más descargado: " + stats.getMax());
        System.out.println("Libro menos descargado: " + stats.getMin());
        System.out.println("Cantidad libros procesados: " + stats.getCount());
    }
}