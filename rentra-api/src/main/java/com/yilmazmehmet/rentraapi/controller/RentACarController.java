package com.yilmazmehmet.rentraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.model.RentACar;
import com.yilmazmehmet.rentraapi.service.RentACarService;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class RentACarController {

	@Autowired
	private RentACarService rentService;

	@PostMapping("/rentacar")
	public ResponseEntity<RentACar> createRent(@RequestBody RentACar rentACar) {

		RentACar addedRentACar = rentService.addRent(rentACar);
		return ResponseEntity.ok(addedRentACar);

	}

}
