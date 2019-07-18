package com.garmin.example.mapping;

import com.garmin.example.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CarMapper implements RowMapper<Car> {

    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("car_id"));
        car.setBrand(resultSet.getString("car_brand"));
        car.setModel(resultSet.getString("car_model"));
        car.setYear(resultSet.getInt("car_year"));
        return car;
    }
}