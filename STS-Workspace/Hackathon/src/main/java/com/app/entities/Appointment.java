package com.app.entities;

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

	
	@Enumerated(EnumType.ORDINAL)
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
