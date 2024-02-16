package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Patient;

public interface PatientDao extends JpaRepository<Patient, Long> {
	Optional<Patient> findByUserEmail(String email);
}
