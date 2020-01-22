package controller;

import com.garmin.example.controller.CarController;
import com.garmin.example.model.Car;
import com.garmin.example.service.CarServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {

    @Mock
    private CarServiceImpl carService;

    @InjectMocks
    private CarController mainController;

    @Test
    public void addCarTest() {
        Car car = new Car();
        mainController.addCar(car);
        verify(carService, times(1)).addCar(car);
    }

    @Test
    public void updateCarTest() {
        Car car = new Car();
        mainController.updateCar(car);
        verify(carService, times(1)).updateCar(car);
    }

    @Test
    public void deleteCarTest() {
        mainController.deleteCar(1);
        verify(carService, times(1)).deleteCar(1);
    }

    @Test
    public void getCarTest() {
        when(carService.getCar(1)).thenReturn(new Car(1));
        Car car = mainController.getCar(1);
        assertNotNull(car);
    }
}
