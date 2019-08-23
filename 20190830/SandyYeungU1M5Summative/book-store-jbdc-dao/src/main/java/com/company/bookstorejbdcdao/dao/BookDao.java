package com.company.bookstorejbdcdao.dao;

import com.company.bookstorejbdcdao.model.Book;

import java.util.List;

public interface BookDao {
    Book getBook(int bookId);

    List<Book> getAllBooks();

    Book addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int bookId);

    List<Book> getBooksByAuthor(int authorId);
}
