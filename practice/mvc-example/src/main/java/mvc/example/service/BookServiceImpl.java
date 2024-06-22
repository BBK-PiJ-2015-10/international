package mvc.example.service;

import mvc.example.entity.Book;
import mvc.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.bookRepository = repository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> saveBooks(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public String deleteBook(int id) {
        bookRepository.deleteById(id);
        return "Deleted book with id " + id;
    }

    @Override
    public boolean updateBook(Book book, int id) {
        var maybeRemoteBook = bookRepository.findById(id);
        if (maybeRemoteBook.isPresent()) {
            var remoteBook = maybeRemoteBook.get();
            remoteBook.setAuthor(book.getAuthor());
            remoteBook.setName(book.getName());
            remoteBook.setPrice(book.getPrice());
            bookRepository.save(remoteBook);
            return true;
        } else {
            return false;
        }
    }
}
