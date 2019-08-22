package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterDaoJdbcTemplateImpl implements RoasterDao {
    //add roaster
    private static final String INSERT_ROASTER_SQL =
            "insert into roaster (name, street, city, state, postal_code, phone, email, note) values (?, ?, ?, ?, ?, ?, ?, ?)";

    //get roaster by roaster id
    private static final String SELECT_COFFEE_BY_ROASTER_ID_SQL =
            "select * from roaster where roaster_id = ?";

    //get all
    private static final String SELECT_ALL_ROASTERS_SQL =
            "select * from roaster";

    //delete one
    private static final String DELETE_ROASTER_SQL =
            "delete from roaster where roaster_id = ?";

    //update one
    private static final String UPDATE_ROASTER_SQL =
            "update roaster set name = ?, street = ?, city =?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? where roaster_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RoasterDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Roaster mapRowToRoaster(ResultSet rs, int rowNum) throws SQLException {
        Roaster roaster = new Roaster();
        roaster.setRoasterId(rs.getInt("roaster_id"));
        roaster.setName(rs.getString("name"));
        roaster.setStreet(rs.getString("street"));
        roaster.setCity(rs.getString("city"));
        roaster.setState(rs.getString("state"));
        roaster.setPostalCode(rs.getString("postal_code"));
        roaster.setPhone(rs.getString("phone"));
        roaster.setEmail(rs.getString("email"));
        roaster.setNote(rs.getString("note"));
        return roaster;
    }

    @Override
    public Roaster getRoaster(int roaster_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_BY_ROASTER_ID_SQL, this::mapRowToRoaster, roaster_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTERS_SQL, this::mapRowToRoaster);
    }

    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL, roaster.getName(), roaster.getStreet(), roaster.getCity(), roaster.getState(), roaster.getPostalCode(), roaster.getPhone(), roaster.getEmail(),
                roaster.getNote());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        roaster.setRoasterId(id);
        return roaster;
    }

    @Override
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL, roaster.getName(), roaster.getStreet(), roaster.getCity(), roaster.getState(), roaster.getPostalCode(), roaster.getPhone(), roaster.getEmail()
                , roaster.getNote(), roaster.getRoasterId());
    }

    @Override
    public void deleteRoaster(int roaster_id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, roaster_id);
    }
}
