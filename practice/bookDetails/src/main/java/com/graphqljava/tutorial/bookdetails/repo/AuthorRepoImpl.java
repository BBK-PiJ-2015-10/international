package com.graphqljava.tutorial.bookdetails.repo;

import com.graphqljava.tutorial.bookdetails.entity.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorRepoImpl implements AuthorRepo {

    @Override
    public List<Author> getAllAuthors() {
        return List.of(new Author("author-1", "Roland", "Kaiser"),
                new Author("author-2", "Maite", "Kelly"),
                new Author("author-3", "Vanessa", "Mai")
        );
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return getAllAuthors().stream().filter(a -> a.id().equals(id)).findFirst();
    }
}
