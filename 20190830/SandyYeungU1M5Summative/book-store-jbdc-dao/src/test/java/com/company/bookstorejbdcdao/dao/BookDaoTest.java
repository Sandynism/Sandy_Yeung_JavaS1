package com.company.bookstorejbdcdao.dao;

import com.company.bookstorejbdcdao.model.Author;
import com.company.bookstorejbdcdao.model.Book;
import com.company.bookstorejbdcdao.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    protected BookDao BookDao;

    @Autowired
    protected AuthorDao AuthorDao;

    @Autowired
    protected PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {
        //clear out child class first
        List<Book> bookList = BookDao.getAllBooks();
        bookList.stream().forEach(b -> BookDao.deleteBook(b.getBookId()));

        List<Author> authorList = AuthorDao.getAllAuthors();
        authorList.stream().forEach(a -> AuthorDao.deleteAuthor(a.getAuthorId()));

        //clear out parent class last
        List<Publisher> publisherList = PublisherDao.getAllPublishers();
        publisherList.stream().forEach(p -> PublisherDao.deletePublisher(p.getPublisherId()));
    }

    @Test
    public void addGetDeleteBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Kristan");
        author.setLastName("Higgins");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("kristanhiggins@prh.com");
        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("045148942X");
        book.setPublishDate(LocalDate.of(2019, 8, 6));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Life and other Conveniences");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("20.00"));
        book = BookDao.addBook(book);

        Book book2 = BookDao.getBook(book.getBookId());
        assertEquals(book, book2);

        BookDao.deleteBook(book.getBookId());

        book2 = BookDao.getBook(book.getBookId());

        assertNull(book2);
    }

    @Test
    public void getAllBooks() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Kristan");
        author.setLastName("Higgins");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("kristanhiggins@prh.com");
        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("045148942X");
        book.setPublishDate(LocalDate.of(2019, Month.AUGUST, 6));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Life and other Conveniences");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(20.00));
        BookDao.addBook(book);

        book.setIsbn("12345678");
        book.setPublishDate(LocalDate.of(2012, Month.APRIL, 24));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Somebody to Love");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(20.00));
        BookDao.addBook(book);

        List<Book> bookList = BookDao.getAllBooks();
        assertEquals(bookList.size(), 2);
    }


    @Test
    public void updateBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Kristan");
        author.setLastName("Higgins");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("kristanhiggins@prh.com");
        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("045148942X");
        book.setPublishDate(LocalDate.of(2019, Month.AUGUST, 6));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Life and other Conveniences");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(20.00));
        book = BookDao.addBook(book);

        book.setIsbn("04148924N");
        book.setPrice(BigDecimal.valueOf(19.99));
        BookDao.updateBook(book);

        Book book2 = BookDao.getBook(book.getBookId());
        assertEquals(book, book2);
    }


    @Test
    public void getBooksByAuthor() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        Author author = new Author();
        author.setFirstName("Kristan");
        author.setLastName("Higgins");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("kristanhiggins@prh.com");
        author = AuthorDao.addAuthor(author);

        Book book = new Book();
        book.setIsbn("045148942X");
        book.setPublishDate(LocalDate.of(2019, Month.AUGUST, 6));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Life and other Conveniences");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(20.00));
        BookDao.addBook(book);

        book.setIsbn("12345678");
        book.setPublishDate(LocalDate.of(2012, Month.APRIL, 24));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Somebody to Love");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(20.00));
        BookDao.addBook(book);

        List<Book> bookList = BookDao.getBooksByAuthor(book.getAuthorId());
        assertEquals(bookList.size(), 2);
    }
}