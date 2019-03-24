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
 

@Entity
@Table(name="transfer")
@Data
public class Transfer implements Serializable{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fromTransfer;
	
	private String toTransfer;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dot")
	private Date dateOfTransfer;
	
	@JsonFormat(pattern = "hh:mm")
	@DateTimeFormat(pattern = "hh:mm")
	@Column(name = "tot")
	private Date timeOfTransfer;
	
	@Column(name = "flight_number")
	private String flightNumber;
	
	@Column(name = "person_count")
	private Integer personCount;
	
	private Integer price;
	
	private String currency;
	
	private String description;
	
	  
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="customer_id",nullable=false)
	private Customer customer;
	

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="car_id",nullable=false)
	private Car car;
	

}
