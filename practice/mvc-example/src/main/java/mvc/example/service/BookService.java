package mvc.example.service;

import mvc.example.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book);

    List<Book> saveBooks(List<Book> books);

    List<Book> getAllBooks();

    Optional<Book> getBookById(int id);

    List<Book> getBooksByAuthor(String author);

    String deleteBook(int id);

    boolean updateBook(Book book,int id);

}
