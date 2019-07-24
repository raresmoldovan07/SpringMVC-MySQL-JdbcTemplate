package com.garmin.example.repository;

import com.garmin.example.mapping.CarMapper;
import com.garmin.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("classpath:queries.properties")
public class CarRepositoryImpl implements CarRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${get.all.query}")
    private String getAllQuery;

    @Value("${add.car.query}")
    private String addCarQuery;

    @Value("${update.car.query}")
    private String updateCarQuery;

    @Value("${delete.car.query}")
    private String deleteCarQuery;

    @Value("${find.car.query}")
    private String findCarQuery;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private SqlParameterSource getSqlParameterByModel(Car car) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (car != null) {
            parameterSource.addValue("id", car.getId());
            parameterSource.addValue("brand", car.getBrand());
            parameterSource.addValue("model", car.getModel());
            parameterSource.addValue("year", car.getYear());
        }
        return parameterSource;
    }

    public List<Car> getAllCars() {
        return namedParameterJdbcTemplate.query(getAllQuery, new CarMapper());
    }

    public void addCar(Car car) {
        namedParameterJdbcTemplate.update(addCarQuery, getSqlParameterByModel(car));
    }

    public void updateCar(Car car) {
        namedParameterJdbcTemplate.update(updateCarQuery, getSqlParameterByModel(car));
    }

    public void deleteCar(int id) {
        namedParameterJdbcTemplate.update(deleteCarQuery, getSqlParameterByModel(new Car(id)));
    }

    public Car findCarById(int id) {
        return namedParameterJdbcTemplate.queryForObject(findCarQuery, getSqlParameterByModel(new Car(id)), new CarMapper());
    }
}
