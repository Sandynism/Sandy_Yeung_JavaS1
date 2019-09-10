package com.company.bookstorejbdcdao.model;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Book {

    private int bookId;
    @NotEmpty(message="Must have isbn.")
    private String isbn;
    @NotEmpty(message="Must have publish date.")
    private LocalDate publishDate;
    @NotEmpty(message="Must have author id.")
    private int authorId;
    @NotEmpty(message="Must have title.")
    private String title;
    @NotEmpty(message="Must have publisher id.")
    private int publisherId;
    @NotEmpty(message="Must have price.")
    private BigDecimal price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() &&
                getAuthorId() == book.getAuthorId() &&
                getPublisherId() == book.getPublisherId() &&
                getIsbn().equals(book.getIsbn()) &&
                getPublishDate().equals(book.getPublishDate()) &&
                getTitle().equals(book.getTitle()) &&
                getPrice().equals(book.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getPublishDate(), getAuthorId(), getTitle(), getPublisherId(), getPrice());
    }

}


