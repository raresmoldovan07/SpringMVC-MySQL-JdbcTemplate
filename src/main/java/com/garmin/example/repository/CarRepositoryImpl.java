package com.garmin.example.repository;

import com.garmin.example.mapping.CarMapper;
import com.garmin.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Car> getAllCars() {
        String sql = "SELECT car_id, car_brand, car_model, car_year FROM cars";
        List<Car> list = namedParameterJdbcTemplate.query(sql, new CarMapper());
        return list;
    }

    public void addCar(Car car) {

    }

    public void updateCar(Car car) {

    }

    public void deleteCar(int id) {

    }

    public Car findCarById(int id) {
        return null;
    }
}
