package com.yilmazmehmet.rentraapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.RentACar;
import com.yilmazmehmet.rentraapi.repository.RentACarRepository;
import com.yilmazmehmet.rentraapi.service.RentACarService;

@Service
public class RentACarServiceImpl implements RentACarService {
	
	private RentACarRepository rentACarRepository;

	@Autowired
	public RentACarServiceImpl(RentACarRepository rentACarRepository) {
		super();
		this.rentACarRepository = rentACarRepository;
	}

	@Override
	public RentACar addRent(RentACar rent) {
	 
		return rentACarRepository.save(rent);
		
	}

}
