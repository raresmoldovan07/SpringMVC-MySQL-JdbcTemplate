package com.garmin.example.controller;

import com.garmin.example.model.Car;
import com.garmin.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getCars(){
        List<Car> list = carService.getAllCars();
        ModelAndView modelAndView = new ModelAndView("cars");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addCar(@RequestBody Car car){
        carService.addCar(car);
        return "index";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCar(@RequestBody Car car){
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
