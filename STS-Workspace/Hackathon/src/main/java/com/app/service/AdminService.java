package com.app.service;

import java.util.List;

import com.app.dto.PatientDTO;
import com.app.entities.Patient;

public interface AdminService {

	List<PatientDTO> getUnregisteredPatients();

	Patient updateDetails(Patient patient);

}
