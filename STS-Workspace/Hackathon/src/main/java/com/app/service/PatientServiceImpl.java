package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PatientDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.dto.RegisterPatientDTO;
import com.app.entities.Patient;
import com.app.entities.UserEntity;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao pDao;
	@Autowired
	private UserEntityDao uDao;
	@Autowired
	private PasswordEncoder encoder;
	 @Override
	public ApiResponse addNewPatient(RegisterPatientDTO patient) {
		 UserEntity user=new UserEntity();
				user.setEmail( patient.getEmail());
				user.setFirstName(patient.getFirstName());
				user.setLastName(patient.getLastName());
				user.setMobileNo(patient.getPhoneNo());
	uDao.save(user);
	
		return new ApiResponse("Patient Created");
	}
	 @Override
	public ApiResponse changePassword(Long patient_id, String password) {
		Patient patient = pDao.findById(patient_id).orElseThrow(()->new ResourceNotFoundException("patient not found"));
		
		patient.getUser().setPassword(encoder.encode(password));
		return new ApiResponse("password changed");
	}
	 @Override
	public ApiResponse updatePatient(PatientDetailDTO patient, Long patient_id) {
		pDao.findById(patient_id).orElseThrow(()->new ResourceNotFoundException("not patient exists of this id"));
		return new ApiResponse("patient updated");
	}
	@Override
	public ApiResponse addPatient(Patient patient) {
		pDao.save(patient);
		return new ApiResponse("Patient Created");
	}
}
