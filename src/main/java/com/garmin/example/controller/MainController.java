package com.garmin.example.controller;

import com.garmin.example.model.Car;
import com.garmin.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value="/cars", method=RequestMethod.GET)
    public String getCars(){
        carService.getAllCars();
        return "index";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addCar(@RequestParam("brand") String brand, @RequestParam("model") String model,
                         @RequestParam("year")int year){
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);

        carService.addCar(car);
        return "index";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String updateCar(@RequestParam("id") int id, @RequestParam("brand") String brand,
                            @RequestParam("model") String model, @RequestParam("year")int year){

        Car car = new Car(id, brand, model, year);

        carService.updateCar(car);
        return "index";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteCar(@PathVariable("id") int id){
        carService.deleteCar(id);
        return "index";
    }

    @RequestMapping(value="get/{id}", method=RequestMethod.GET)
    public String getCar(@PathVariable("id") int id){
        carService.findCarById(id);
        return "index";
    }
}
