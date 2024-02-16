package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Appointment extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@JsonIgnoreProperties(value = "appointments")
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	private LocalDate date;
	
	private LocalTime time;
	
	@Lob
	private String remarks; 
	@Lob
	private String medication;

	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Type type;

	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Slot slot;

	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Appstatus status;

	

	

}
