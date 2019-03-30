package com.yilmazmehmet.rentraapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.Car;
import com.yilmazmehmet.rentraapi.service.CarService;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/car")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {

		Car addedCar = carService.addCar(car);

		return ResponseEntity.ok(addedCar);

	}
	@GetMapping("/car")
	public ResponseEntity<List<Car>> getAllCar() {

		List<Car> carList = carService.getAllCar();

		if (carList.isEmpty()) {

			throw new NoSuchEntityFoundException("Cars not found");
		}

		return ResponseEntity.ok(carList);
	}
	
	@GetMapping(path = "/car/p", params = { "carType" })
	public ResponseEntity<List<Car>> getCarByType(@RequestParam(name = "carType") String carType) {

		List<Car> carTypedList = carService.getCarByType(carType);

		if (carTypedList.isEmpty()) {

			throw new NoSuchEntityFoundException("No car found typedd : " + carType);
		}

		return ResponseEntity.ok(carTypedList);
	}
	
	@PutMapping("/car/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Long carId,
			@RequestBody Car car) {
		Optional<Car> optional = carService.findCarById(carId);

		if (!optional.isPresent()) {

			throw new NoSuchEntityFoundException("Car Id not found ->" + carId);

		} else {

			car.setId(carId);

			return ResponseEntity.ok(carService.updateCar(car));
		}

	}
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable(value = "id") Long carId) {
		Optional<Car> optional = carService.findCarById(carId);

		if (!optional.isPresent()) {

			throw new NoSuchEntityFoundException("Car Id not found ->" + carId);

		} else {

			carService.deleteCar(carId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(" " + carId.toString() + " id is successfully deleted.");
		}

	}
	
	
	@GetMapping(path = "/car/p", params = { "licensePlate" })
	public ResponseEntity<Car> getCarBylicensePlate(@RequestParam(name = "licensePlate") String licensePlate) {

		Car car = carService.findBylicensePlate(licensePlate)
				.orElseThrow(()-> new NoSuchEntityFoundException("Car not found licensePlate -> " + licensePlate));

		 return ResponseEntity.ok(car);
	}

}
