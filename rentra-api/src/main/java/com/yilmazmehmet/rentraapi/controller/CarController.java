package com.yilmazmehmet.rentraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.model.Car;
import com.yilmazmehmet.rentraapi.service.CarService;

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

}
