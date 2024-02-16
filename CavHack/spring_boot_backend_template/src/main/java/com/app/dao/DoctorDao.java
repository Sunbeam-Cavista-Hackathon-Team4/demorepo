package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Doctor;
import com.app.entities.UserEntity;
import com.app.entities.Address;
import com.app.entities.City;

import java.util.List;
import java.util.Optional;

public interface DoctorDao extends JpaRepository<Doctor, Long> {
	List<Doctor> findByAddressCity(City city);

	Optional<Doctor> findByUserEmail(String email);
}
