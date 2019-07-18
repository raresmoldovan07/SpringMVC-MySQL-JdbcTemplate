package com.garmin.example.service;

import com.garmin.example.model.Car;
import com.garmin.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.updateCar(car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteCar(id);
    }

    @Override
    public Car findCarById(int id) {
        return carRepository.findCarById(id);
    }
}
