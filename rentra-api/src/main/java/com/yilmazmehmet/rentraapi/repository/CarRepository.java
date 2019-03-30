package com.yilmazmehmet.rentraapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilmazmehmet.rentraapi.model.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
	
	
	List<Car> findBycarType(String carType);
	
	Optional<Car> findBylicensePlate(String licensePlate);
	
	
	
}
