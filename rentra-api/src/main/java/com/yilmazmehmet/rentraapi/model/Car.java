package com.yilmazmehmet.rentraapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="car")
@Data
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String model;
	
	@JsonFormat(pattern = "yyyy")
	@DateTimeFormat(pattern = "yyyy")
	@Column(name = "model_date")
	private Date modelDate;
	
	
	@Column(name = "license_plate")
	private String licensePlate;
	
	@Column(name = "car_type")
	private String carType;
	
	
}
