package com.garmin.example.service;

import com.garmin.example.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int id);

    Car getCar(int id);
}
