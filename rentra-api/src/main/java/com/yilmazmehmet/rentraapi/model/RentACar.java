package com.yilmazmehmet.rentraapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//@Entity
//@Table(name="rent_a_car")
@Data
public class RentACar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String from ;
	
	 
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dor")
	private Date dateOfRent;
	
	@JsonFormat(pattern = "hh:mm")
	@DateTimeFormat(pattern = "hh:mm")
	@Column(name = "tor")
	private Date timeOfRent;
	
	
	private Integer price;
	
	private String currency;
	
	private String description;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="customer_id",nullable=false)
	private Customer customer;
	

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="car_id",nullable=false)
	private Car car;
*/
}
