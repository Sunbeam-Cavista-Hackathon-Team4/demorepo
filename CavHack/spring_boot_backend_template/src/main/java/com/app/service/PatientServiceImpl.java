package com.app.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PatientDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.dto.RegisterPatientDTO;
import com.app.dto.SignInDTO;
import com.app.dto.SigninRequest;
import com.app.entities.Patient;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao pDao;
	@Autowired
	private UserEntityDao uDao;
	
	 @Override
	public ApiResponse addNewPatient(RegisterPatientDTO patient) {
		 UserEntity user=new UserEntity();
				user.setEmail( patient.getEmail());
				user.setFirstName(patient.getFirstName());
				user.setLastName(patient.getLastName());
				user.setMobileNo(patient.getPhoneNo());
				Patient p = new Patient();
				p.setUser(user);
				pDao.save(p);
	uDao.save(user);
	
		return new ApiResponse("Patient Created");
	}
	 @Override
	public ApiResponse changePassword(Long patient_id, String password) {
		Patient patient = pDao.findById(patient_id).orElseThrow(()->new ResourceNotFoundException("patient not found"));
		
		patient.getUser().setPassword(password);
		return new ApiResponse("password changed");
	}
	 @Override
	public ApiResponse updatePatient(PatientDetailDTO patient, Long patient_id) {
		Patient pat = pDao.findById(patient_id).orElseThrow(()->new ResourceNotFoundException("not patient exists of this id"));
		pat.setAddress(patient.getAddress());
		pat.setCategory(patient.getCategory());
		patient.getEmail();
		patient.getMobileNo();
		patient.getGender();
		patient.getFirstName();patient.getAddress();
		patient.getLastName();
		return new ApiResponse("patient updated");
	}
	 
	 @Override
	public Patient signIn(@Valid SigninRequest reqDTO) {
		Patient patient = pDao.findByUserEmailAndUserPassword(reqDTO.getEmail(),reqDTO.getPassword()).orElseThrow(null);
		//SignInDTO dto = new SignInDTO(patient.getId(),UserRole.ROLE_PATIENT//);
		
		return patient;
	}
}