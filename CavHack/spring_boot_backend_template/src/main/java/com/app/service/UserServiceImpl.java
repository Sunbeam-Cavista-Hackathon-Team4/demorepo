package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dao.UserEntityDao;
import com.app.dto.SignInDTO;
import com.app.dto.SigninRequest;
import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private UserEntityDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private DoctorDao docDao;
	
	
	@Override
	public UserEntity findByEmailAddress(String email) {
		return userDao.findByEmail(email).orElse(null);
	}
	
	@Override
	public SignInDTO signIn(SigninRequest dto) {
		SignInDTO sDto = new SignInDTO();
		UserEntity user = userDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
		if(user.getRole() == UserRole.ROLE_PATIENT) {
			Patient patient = patientDao.findByUserEmail(dto.getEmail()).orElse(null);
			sDto.setId(patient.getId());
			sDto.setRole(UserRole.ROLE_PATIENT);
		}
		else if(user.getRole() == UserRole.ROLE_DOCTOR) {
			Doctor doctor = docDao.findByUserEmail(dto.getEmail()).orElse(null);
			sDto.setId(doctor.getId());
			sDto.setRole(UserRole.ROLE_DOCTOR);
		}
		return sDto;
	}

}
