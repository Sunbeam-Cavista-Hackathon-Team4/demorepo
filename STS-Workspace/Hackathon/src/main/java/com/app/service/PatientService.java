package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.RegisterPatientDTO;

public interface PatientService {

	ApiResponse addNewPatient(RegisterPatientDTO patient);

	ApiResponse changePassword(Long patient_id, String password);

}
