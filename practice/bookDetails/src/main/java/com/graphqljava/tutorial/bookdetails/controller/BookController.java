package com.graphqljava.tutorial.bookdetails.controller;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import com.graphqljava.tutorial.bookdetails.repo.AuthorRepo;
import com.graphqljava.tutorial.bookdetails.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import org.springframework.stereotype.Controller;


import com.graphqljava.tutorial.bookdetails.entity.Book;


@Controller
public class BookController {

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    @Autowired
    public BookController(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

//    @QueryMapping
//    public Book bookById(@Argument String id) {
//        return bookRepo.getById(id).orElse(null);
//    }
//
//    @SchemaMapping
//    public Author author(Book book) {
//        return authorRepo.getAuthorById(book.authorId()).orElse(null);
//    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        System.out.println("Book ID: " + id);
        return bookRepo.getById(id).orElse(null);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepo.getAuthorById(book.authorId()).orElse(null);
    }

}
