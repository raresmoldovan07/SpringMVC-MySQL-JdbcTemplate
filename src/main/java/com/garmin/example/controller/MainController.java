package com.garmin.example.controller;

import com.garmin.example.model.Car;
import com.garmin.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class MainController {

    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCars() {
        List<Car> list = carService.getAllCars();
        ModelAndView modelAndView = new ModelAndView("cars");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable("id") int id) {
        carService.deleteCar(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getCar(@PathVariable("id") int id) {
        return carService.getCar(id);
    }
}
