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
public class PublisherDaoTest {
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
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        Publisher publisher2 = PublisherDao.getPublisher(publisher.getPublisherId());
        assertEquals(publisher, publisher2);

        PublisherDao.deletePublisher(publisher.getPublisherId());
        publisher2 = PublisherDao.getPublisher(publisher.getPublisherId());
        assertNull(publisher2);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        PublisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Harper Collins");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10007");
        publisher.setPhone("2122077000");
        publisher.setEmail("harpercollins@harpercollins.com");
        PublisherDao.addPublisher(publisher);

        List<Publisher> publisherList = PublisherDao.getAllPublishers();
        assertEquals(publisherList.size(), 2);
    }


    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("Broadway");
        publisher.setCity("New York");
        publisher.setState("NY");
        publisher.setPostalCode("10019");
        publisher.setPhone("8007932665");
        publisher.setEmail("randomhouse@prh.com");
        publisher = PublisherDao.addPublisher(publisher);

        publisher.setName("Penguin Random House");
        PublisherDao.updatePublisher(publisher);

        Publisher publisher2 = PublisherDao.getPublisher(publisher.getPublisherId());
        assertEquals(publisher, publisher2);
    }
}