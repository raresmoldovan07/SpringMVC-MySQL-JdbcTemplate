package com.garmin.example.repository;

import com.garmin.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface CarRepository {

    List<Car> getAllCars();

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int id);

    Car getCar(int id);
}
