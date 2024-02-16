package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PatientDao;
import com.app.dao.UnregisteredUserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.entities.Patient;
import com.app.entities.UnregisteredUser;
import com.app.entities.UserEntity;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UnregisteredUserDao uudao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PatientDao pdao;
	
	@Override
	public List<PatientDetailDTO> getUnregisteredPatients() {
		List<UnregisteredUser> userList = uudao.findByIsRegisteredIsFalse();
		return userList.stream().map(user-> mapper.map(user,PatientDetailDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateDetails(PatientDetailDTO patient) {
		Patient persistPatient = pdao.findByUserEmail(patient.getEmail()).orElseThrow(()->new EntityNotFoundException("Not found"));
		persistPatient.setAddress(patient.getAddress());
		persistPatient.setCategory(patient.getCategory());
		persistPatient.setDob(patient.getDob());
		UserEntity pUser = persistPatient.getUser();
		pUser.setGender(patient.getGender());
		return new ApiResponse("Patient details updated..");
	}

}
