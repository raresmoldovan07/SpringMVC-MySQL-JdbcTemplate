package com.garmin.example.controller;

import com.garmin.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(name="/", method= RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
}
