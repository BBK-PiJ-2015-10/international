package com.graphqljava.tutorial.bookdetails.repo;

import com.graphqljava.tutorial.bookdetails.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepoImpl implements BookRepo {

    @Override
    public List<Book> getAllBooks() {
        return List.of(
                new Book("book-1", "Harry Potter and the Philosopher's Stone", 1, "author-1"),
                new Book("book-2", "Moby Dick", 635, "author-2"),
                new Book("book-3", "Interview with the vampire", 371, "author-3")
        );

    }

    @Override
    public Optional<Book> getById(String id) {
        return getAllBooks().stream().filter(b -> b.id().equals(id)).findFirst();
    }
}
