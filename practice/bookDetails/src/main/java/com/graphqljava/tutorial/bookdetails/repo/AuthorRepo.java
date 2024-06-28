package com.graphqljava.tutorial.bookdetails.repo;

import com.graphqljava.tutorial.bookdetails.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepo {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(String id);

}
