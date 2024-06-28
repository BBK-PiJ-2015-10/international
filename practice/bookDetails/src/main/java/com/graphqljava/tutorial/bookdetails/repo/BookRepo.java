package com.graphqljava.tutorial.bookdetails.repo;

import com.graphqljava.tutorial.bookdetails.entity.Book;

import java.util.List;

public interface BookRepo {

    List<Book> getAllBooks();

    Book getById(String id);

}
