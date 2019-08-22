package com.company.motoinventoryjdbctemplatedao.dao;

import com.company.motoinventoryjdbctemplatedao.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MotoInventoryDaoJdbcTemplateImpl implements MotoInventoryDao {

    // Prepared statement strings
    private static final String INSERT_MOTO_SQL =
            "insert into motorcycle (vin, make, model, year, color) values (?, ?, ?, ?, ?)";

    private static final String SELECT_MOTO_SQL =
            "select * from motorcycle where id = ?";

    private static final String SELECT_ALL_MOTOS_SQL =
            "select * from motorcycle";

    private static final String DELETE_MOTO_SQL =
            "delete from motorcycle where id = ?";

    private static final String UPDATE_MOTO_SQL =
            "update motorcycle set vin = ?, make = ?, model = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_MOTOS_BY_MAKE_SQL =
            "select * from motorcycle where make = ?";

    private JdbcTemplate jdbcTemplate;


    //custom constructor with jdbctemplate parameter
    @Autowired
    public MotoInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //maps the Motorcycle object to the sql rows and column names
    private Motorcycle mapRowToMotorcycle(ResultSet rs, int rowNum) throws SQLException {
        Motorcycle moto = new Motorcycle();
        moto.setId(rs.getInt("id"));
        moto.setMake(rs.getString("make"));
        moto.setModel(rs.getString("model"));
        moto.setVin(rs.getString("vin"));
        moto.setYear(rs.getString("year"));
        moto.setColor(rs.getString("color"));

        return moto;
    }


    //in this::mapRowToMotorcycle, you are passing a method to the jdbcTemplate.
    @Override
    public Motorcycle getMotorcycle(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_MOTO_SQL, this::mapRowToMotorcycle, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //returns a list of motorcycles from database
    @Override
    public List<Motorcycle> getAllMotorcycles() {
        return jdbcTemplate.query(SELECT_ALL_MOTOS_SQL, this::mapRowToMotorcycle);
    }

    @Override
    @Transactional
    //used when there are more than one executions to make sure that it executes all or none.
    public Motorcycle addMotorcycle(Motorcycle motorcycle) {
        jdbcTemplate.update(INSERT_MOTO_SQL, motorcycle.getVin(), motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(), motorcycle.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        motorcycle.setId(id);
        return motorcycle;
    }

    //updates a Motorcycle object
    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {
        jdbcTemplate.update(UPDATE_MOTO_SQL, motorcycle.getVin(), motorcycle.getMake(), motorcycle.getModel(), motorcycle.getYear(), motorcycle.getColor(), motorcycle.getId());
    }

    //deletes by id
    @Override
    public void deleteMotorcycle(int id) {
        jdbcTemplate.update(DELETE_MOTO_SQL, id);
    }

    //gets motorcycles by make
    @Override
    public List<Motorcycle> getMotorcyclesByMake(String make) {
        return jdbcTemplate.query(SELECT_MOTOS_BY_MAKE_SQL, this::mapRowToMotorcycle, make);
    }
}
