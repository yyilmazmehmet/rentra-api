package com.yilmazmehmet.rentraapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.RentACar;
import com.yilmazmehmet.rentraapi.repository.RentACarRepository;

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
