package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.UnregisteredUserDao;
import com.app.dto.PatientDTO;
import com.app.entities.Patient;
import com.app.entities.UnregisteredUser;

public class AdminServiceImpl implements AdminService{

	@Autowired
	private UnregisteredUserDao uudao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<PatientDTO> getUnregisteredPatients() {
		List<UnregisteredUser> userList = uudao.findByIsRegisteredIsFalse();
		return userList.stream().map(user-> mapper.map(user,PatientDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Patient updateDetails(Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

}
