package com.company.bookstorejbdcdao.dao;

import com.company.bookstorejbdcdao.model.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher getPublisher(int publisherId);

    List<Publisher> getAllPublishers();

    Publisher addPublisher(Publisher publisher);

    void updatePublisher(Publisher publisher);

    void deletePublisher(int publisherId);
}
