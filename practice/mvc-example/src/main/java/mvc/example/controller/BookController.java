package mvc.example.controller;


import mvc.example.entity.Book;
import mvc.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> retrieveBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/id/{id}")
    public Book retrieveBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id).orElse(null);
    }

    @GetMapping("/books/author/{name}")
    public List<Book> retrieveBooksByAuthor(@PathVariable("name") String name) {
        return bookService.getBooksByAuthor(name);
    }

    @DeleteMapping("/books/id/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }


    @PostMapping("/books")
    public List<Book> createBooks(@RequestBody List<Book> books) {
        return this.bookService.saveBooks(books);
    }

    @PutMapping("/books/id/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.updateBook(book, id);
    }

}
