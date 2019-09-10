package com.company.bookstorejbdcdao.dao;

import com.company.bookstorejbdcdao.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcImpl implements PublisherDao {
    private static final String SELECT_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "select * from publisher";

    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? where publisher_id = ?";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PublisherDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Helper methods
    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }

    @Override
    public Publisher getPublisher(int publisherId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, publisherId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(), publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        publisher.setPublisherId(id);
        return publisher;
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL, publisher.getName(), publisher.getStreet(), publisher.getCity(), publisher.getState(), publisher.getPostalCode(), publisher.getPhone(), publisher.getEmail(), publisher.getPublisherId());
    }

    @Override
    public void deletePublisher(int publisherId) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisherId);
    }
}
