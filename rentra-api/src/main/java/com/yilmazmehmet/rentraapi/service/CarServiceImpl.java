package com.yilmazmehmet.rentraapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.Car;
import com.yilmazmehmet.rentraapi.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepository;
	
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public Car addCar(Car car) {
		
		return carRepository.save(car);
		 
	}

}
