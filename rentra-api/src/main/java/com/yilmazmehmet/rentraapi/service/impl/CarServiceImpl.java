package com.yilmazmehmet.rentraapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.Car;
import com.yilmazmehmet.rentraapi.repository.CarRepository;
import com.yilmazmehmet.rentraapi.service.CarService;

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

	@Override
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	@Override
	public List<Car> getCarByType(String carType) {

		return carRepository.findBycarType(carType.toLowerCase());
	}

	@Override
	public Optional<Car> findCarById(Long id) {

		return carRepository.findById(id);
	}

	@Override
	public Boolean deleteCar(Long id) {
		carRepository.deleteById(id);

		return true;
	}

	@Override
	public Car updateCar(Car car) {

		return carRepository.save(car);
	}

	@Override
	public Optional<Car> findBylicensePlate(String licensePlate) {
		return carRepository.findBylicensePlate(licensePlate);
	}

}
