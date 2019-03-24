package com.yilmazmehmet.rentraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilmazmehmet.rentraapi.model.Car;

public interface CarRepository extends JpaRepository<Car,Long> {

}
