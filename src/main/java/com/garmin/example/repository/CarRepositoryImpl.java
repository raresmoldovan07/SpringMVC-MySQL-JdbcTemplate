package com.garmin.example.repository;

import com.garmin.example.mapping.CarMapper;
import com.garmin.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private Map<String, Object> getSqlParameterByMap(Car car){
        Map<String, Object> parameterMap = new HashMap<>();
        if(car != null){
            parameterMap.put("id", car.getId());
            parameterMap.put("brand", car.getBrand());
            parameterMap.put("model", car.getModel());
            parameterMap.put("year", car.getYear());
        }
        return parameterMap;
    }

    private SqlParameterSource getSqlParameterByModel(Car car){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(car != null){
            parameterSource.addValue("id", car.getId());
            parameterSource.addValue("brand", car.getBrand());
            parameterSource.addValue("model", car.getModel());
            parameterSource.addValue("year", car.getYear());
        }
        return parameterSource;
    }

    public List<Car> getAllCars() {
        String sql = "SELECT car_id, car_brand, car_model, car_year FROM cars";
        List<Car> list = namedParameterJdbcTemplate.query(sql, new CarMapper());
        return list;
    }

    public void addCar(Car car) {
        String sql = "INSERT INTO cars(car_brand, car_model, car_year) VALUES (:brand, :model, :year)";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByMap(car));
    }

    public void updateCar(Car car) {
        String sql = "UPDATE cars SET car_brand=:brand, car_model=:model, car_year=:year WHERE car_id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(car));
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM cars WHERE car_id=:id";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByMap(new Car(id)));
    }

    public Car findCarById(int id) {
        String sql = "SELECT * FROM cars WHERE car_id=:id";
        return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Car(id)), new CarMapper());
    }
}
