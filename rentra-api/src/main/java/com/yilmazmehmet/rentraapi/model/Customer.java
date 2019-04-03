package com.yilmazmehmet.rentraapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value= {"createdAt","updatedAt"},allowGetters=true)
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	 
	@Column(name = "last_name")
	private String lastName;

	private String gender;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private Date dateOfBirth;

	private String email;

	@Column(nullable = false, updatable = false, name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonIgnoreProperties
	private Date createdAt;

	@Column(nullable = false, name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonIgnoreProperties
	private Date updatedAt;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Phone> phoneList = new HashSet<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Address> addressList = new HashSet<>();

/*	
	@JsonIgnoreProperties
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private Transfer transfer;
	
	@JsonIgnoreProperties
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private RentACar rentACar;
*/
}
