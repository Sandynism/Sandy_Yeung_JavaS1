package com.company.bookstorejbdcdao.dao;

import com.company.bookstorejbdcdao.model.Author;

import java.util.List;

public interface AuthorDao {
    Author getAuthor(int authorId);

    List<Author> getAllAuthors();

    Author addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int authorId);
}
