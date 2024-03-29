package com.company.carinventoryjdbctemplatedao.dao;

import com.company.carinventoryjdbctemplatedao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarInventoryDaoJdbcTemplateImpl implements CarInventoryDao {

    private static final String INSERT_CAR_SQL =
            "insert into car (make, model, year, color) values (?, ?, ?, ?)";

    private static final String SELECT_CAR_BY_ID_SQL =
            "select * from car where id = ?";

    private static final String SELECT_ALL_CARS_SQL =
            "select * from car";

    private static final String DELETE_CAR_SQL =
            "delete from car where id = ?";

    private static final String UPDATE_CAR_SQL =
            "update car set make = ?, model = ?, year = ?, color = ? where id = ?";

    private static final String SELECT_CAR_BY_MAKE =
            "select * from car where make = ?";

    private static final String SELECT_CAR_BY_COLOR =
            "select * from car where color = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //helper methods
    private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getString("year"));
        car.setColor(rs.getString("color"));
        return car;
    }

    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    @Override
    public Car getCarById(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CAR_BY_ID_SQL, this::mapRowToCar, id);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Car addCar(Car car) {
        jdbcTemplate.update(INSERT_CAR_SQL, car.getMake(), car.getModel(), car.getYear(), car.getColor());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        car.setId(id);
        return car;
    }

    @Override
    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL, car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getId());
    }

    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    @Override
    public List<Car> getCarByMake(String make) {
        return jdbcTemplate.query(SELECT_CAR_BY_MAKE, this::mapRowToCar, make);
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return jdbcTemplate.query(SELECT_CAR_BY_COLOR, this::mapRowToCar, color);
    }
}
