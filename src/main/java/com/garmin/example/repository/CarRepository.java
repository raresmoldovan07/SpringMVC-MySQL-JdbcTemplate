package com.garmin.example.repository;

import com.garmin.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    private List<Car> carList = new ArrayList<Car>();

    public List<Car> getAll(){
        return carList;
    }
}
