package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dao.PatientDao;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	private PatientDao pDao;
	
}
