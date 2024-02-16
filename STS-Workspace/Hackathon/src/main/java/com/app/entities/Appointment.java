package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
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
	
	private String remarks; 

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Enumerated(EnumType.STRING)
	private Type type;

	@Enumerated(EnumType.STRING)
	private Slot slot;

	@Enumerated(EnumType.ORDINAL)
	private Appstatus status;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Appstatus getStatus() {
		return status;
	}

	public void setStatus(Appstatus status) {
		this.status = status;
	}

}
