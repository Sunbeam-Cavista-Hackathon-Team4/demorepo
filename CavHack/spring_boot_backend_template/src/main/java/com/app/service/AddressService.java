package com.app.service;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;

public interface AddressService {

	ApiResponse assignPatientAddress(Long patientId, AddressDTO adr);

	ApiResponse updateAddress(Long AddressId, AddressDTO adr);
	
	Address getById(Long AddressId);

}
