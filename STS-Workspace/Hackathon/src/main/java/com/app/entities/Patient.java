package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Patient extends BaseEntity  {

	@Column(length = 30,nullable = false)
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	
	@Column(length = 15)
	private String mobileNo;
	@Lob
	private String issue;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	

	
		
	

	

	
	
	public void addAppointment(Appointment a) {
		this.appointments.add(a);
		a.setPatient(this);
	}
	
	
	
	
}
