package com.graphqljava.tutorial.bookdetails.repo;

import com.graphqljava.tutorial.bookdetails.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepo {

    List<Book> getAllBooks();

    Optional<Book> getById(String id);

}
