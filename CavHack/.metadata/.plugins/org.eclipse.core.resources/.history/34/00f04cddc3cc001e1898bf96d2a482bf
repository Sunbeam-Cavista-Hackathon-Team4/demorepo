package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;
import com.app.entities.Address;
import com.app.entities.City;

import java.util.List;

public interface DoctorDao extends JpaRepository<Doctor, Long> {
	List<Doctor> findByAddressCity(City city);
}
