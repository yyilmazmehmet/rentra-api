package com.yilmazmehmet.rentraapi.service;

import java.util.List;
import java.util.Optional;

import com.yilmazmehmet.rentraapi.model.Car;

public interface CarService {
	
	Car addCar(Car car);
	List<Car> getAllCar();
	List<Car> getCarByType(String carType);
	Optional<Car> findCarById(Long id);
	Boolean deleteCar(Long id);
	Car updateCar(Car car);
	Optional<Car> findBylicensePlate(String licensePlate);


}
