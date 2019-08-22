package com.company.coffeeinventoryjdbctemplatedao.dao;

import com.company.coffeeinventoryjdbctemplatedao.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeInventoryDaoJdbcTemplateImpl implements CoffeeInventoryDao {

    //add coffee
    private static final String INSERT_COFFEE_SQL =
            "insert into coffee (roaster_id, name, count, unit_price, description, type) values (?, ?, ?, ?, ?, ?)";

    //get coffee by roaster id
    private static final String SELECT_COFFEE_BY_ROASTER_ID_SQL =
            "select * from coffee where roaster_id = ?";

    //get coffee by coffee id
    private static final String SELECT_COFFEE_BY_COFFEE_ID_SQL =
            "select * from coffee where coffee_id = ?";

    //get all
    private static final String SELECT_ALL_COFFEES_SQL =
            "select * from coffee";

    //delete one
    private static final String DELETE_COFFEE_SQL =
            "delete from coffee where coffee_id = ?";

    //update one
    private static final String UPDATE_COFFEE_SQL =
            "update coffee set roaster_id = ?, name = ?, count = ?, unit_price = ?, description = ?, type = ? where coffee_id = ?";

    //get coffees by type
    private static final String SELECT_COFFEES_BY_TYPE_SQL =
            "select * from coffee where type = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Coffee mapRowToCoffee(ResultSet rs, int rowNum) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setCoffeeId(rs.getInt("coffee_id"));
        coffee.setRoasterId(rs.getInt("roaster_id"));
        coffee.setName(rs.getString("name"));
        coffee.setCount(rs.getInt("count"));
        coffee.setUnitPrice(rs.getDouble("unit_price"));
        coffee.setDescription(rs.getString("description"));
        coffee.setType(rs.getString("type"));
        return coffee;
    }


    @Override
    public List<Coffee> getAllCoffees() {
        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL, this::mapRowToCoffee);
    }

    @Override
    public Coffee getCoffeeByCoffeeId(int coffee_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_BY_COFFEE_ID_SQL, this::mapRowToCoffee, coffee_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL, coffee.getRoasterId(), coffee.getName(), coffee.getCount(), coffee.getUnitPrice(), coffee.getDescription(), coffee.getType());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        coffee.setCoffeeId(id);
        return coffee;
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL, coffee.getRoasterId(), coffee.getName(), coffee.getCount(), coffee.getUnitPrice(), coffee.getDescription(), coffee.getType(), coffee.getCoffeeId());
    }

    @Override
    public void deleteCoffee(int coffee_id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, coffee_id);
    }

    @Override
    public List<Coffee> getCoffeeByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEES_BY_TYPE_SQL, this::mapRowToCoffee, type);
    }

    @Override
    public List<Coffee> getCoffeeByRoasterId(int roaster_id) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER_ID_SQL, this::mapRowToCoffee, roaster_id);
    }
}
