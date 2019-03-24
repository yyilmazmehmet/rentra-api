package com.yilmazmehmet.rentraapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
 

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

 

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type")
	private String type;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "neighborhood")
	private String neighborhood;

	@Column(name = "street")
	private String street;

	@Column(name = "apartment_name")
	private String apartmentName;

	@Column(name = "apartment_number")
	private String apartmentNumber;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	@JsonIgnore // fixed bidirectional problem	.	 
	private Customer customer;

	@Override
	public int hashCode() {
		return Objects.hash(apartmentName, apartmentNumber, city, district, id, neighborhood, street, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(apartmentName, other.apartmentName)
				&& Objects.equals(apartmentNumber, other.apartmentNumber) && Objects.equals(city, other.city)
				&& Objects.equals(district, other.district) && Objects.equals(id, other.id)
				&& Objects.equals(neighborhood, other.neighborhood) && Objects.equals(street, other.street)
				&& Objects.equals(type, other.type);
	}
	
	


}
