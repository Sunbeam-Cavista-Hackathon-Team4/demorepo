
package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DoctorDao;
import com.app.dto.DoctorDTO;
import com.app.entities.City;
import com.app.entities.Doctor;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	public DoctorDao doctorDao;
	
	@Autowired
	public ModelMapper mapper;
	
	
	
	
	@Override
	public DoctorDTO addDoctor(DoctorDTO doctorDto) {
		Doctor doctor = mapper.map(doctorDto, Doctor.class);
		return mapper.map(doctorDao.save(doctor), DoctorDTO.class);
	}

	@Override
	public DoctorDTO getDoctorbyId(Long doctorId) {
		Doctor doctor = doctorDao.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor not found!!"));
		return mapper.map(doctor, DoctorDTO.class);
	}

	@Override
	public List<DoctorDTO> getDoctorByCity(City city) {
		return doctorDao.findByAddressCity(city).stream().map(d -> mapper.map(d, DoctorDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<DoctorDTO> getAllDoctor() {
		return doctorDao.findAll().stream().map(d->mapper.map(d, DoctorDTO.class)).collect(Collectors.toList());
		
	}
	
	
	
}