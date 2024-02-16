package com.app.service;

import java.util.List;

import com.app.dto.DoctorDTO;
import com.app.entities.City;

public interface DoctorService {

	DoctorDTO addDoctor(DoctorDTO doctorDto);

	DoctorDTO getDoctorbyId(Long doctorId);

	List<DoctorDTO> getDoctorByCity(City city);

	List<DoctorDTO> getAllDoctor();

}