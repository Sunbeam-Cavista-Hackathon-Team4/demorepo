package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.entities.Patient;

public interface AdminService {

	List<PatientDetailDTO> getUnregisteredPatients();

	ApiResponse updateDetails(PatientDetailDTO patient);

}
