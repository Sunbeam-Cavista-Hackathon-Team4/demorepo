package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.dto.RegisterPatientDTO;
import com.app.entities.Patient;

public interface PatientService {

	ApiResponse addNewPatient(RegisterPatientDTO patient);

	ApiResponse changePassword(Long patient_id, String password);
	
	ApiResponse updatePatient(PatientDetailDTO patient,Long patient_id);

	ApiResponse addPatient(Patient patient);
}
