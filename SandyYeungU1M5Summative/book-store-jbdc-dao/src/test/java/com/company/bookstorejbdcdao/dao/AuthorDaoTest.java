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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {
    @Autowired
    protected BookDao BookDao;

    @Autowired
    protected AuthorDao AuthorDao;

    @Autowired
    protected PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = BookDao.getAllBooks();
        bookList.stream().forEach(b -> BookDao.deleteBook(b.getBookId()));

        List<Author> authorList = AuthorDao.getAllAuthors();
        authorList.stream().forEach(a -> AuthorDao.deleteAuthor(a.getAuthorId()));

        List<Publisher> publisherList = PublisherDao.getAllPublishers();
        publisherList.stream().forEach(p -> PublisherDao.deletePublisher(p.getPublisherId()));
    }

    @Test
    public void addGetDeleteAuthor() {
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

        Author author2 = AuthorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author2);

        AuthorDao.deleteAuthor(author.getAuthorId());

        author2 = AuthorDao.getAuthor(author.getAuthorId());
        assertNull(author2);
    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirstName("Kristan");
        author.setLastName("Higgins");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("kristanhiggins@prh.com");
        AuthorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Hannah");
        author.setLastName("Shaw");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("hannahshaw@prh.com");
        AuthorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Robert");
        author.setLastName("Crais");
        author.setStreet("Broadway");
        author.setCity("New York");
        author.setState("NY");
        author.setPostalCode("10019");
        author.setPhone("8007932665");
        author.setEmail("robertcrais@prh.com");
        AuthorDao.addAuthor(author);

        List<Author> authorList = AuthorDao.getAllAuthors();
        assertEquals(authorList.size(), 3);
    }

    @Test
    public void updateAuthor() {
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

        author.setEmail("kristanhiggins2@prh.com");
        AuthorDao.updateAuthor(author);

        Author author2 = AuthorDao.getAuthor(author.getAuthorId());
        assertEquals(author, author2);
    }
}