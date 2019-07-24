package service;

import com.garmin.example.model.Car;
import com.garmin.example.repository.CarRepositoryImpl;
import com.garmin.example.service.CarServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {

    @Mock
    private CarRepositoryImpl carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void addCarTest() {
        Car car = new Car();
        carService.addCar(car);
        verify(carRepository, times(1)).addCar(car);
    }

    @Test
    public void updateCarTest() {
        Car car = new Car();
        carService.updateCar(car);
        verify(carRepository, times(1)).updateCar(car);
    }

    @Test
    public void deleteCarTest() {
        carService.deleteCar(1);
        verify(carRepository, times(1)).deleteCar(1);
    }

    @Test
    public void getCarTest() {
        when(carRepository.getCar(1)).thenReturn(new Car(1));
        Car car = carService.getCar(1);
        assertNotNull(car);
    }
}
