package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.PatientDao;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.Patient;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao adrDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse assignPatientAddress(Long patientId, AddressDTO adr) {
		Patient patient = patientDao.getReferenceById(patientId);

		Address addressEntity = mapper.map(adr, Address.class);

		patient.setAddress(adrDao.save(addressEntity));

		return new ApiResponse("Address Saved Successfully....");
	}

	public ApiResponse updateAddress(Long AddressId, AddressDTO adr) {

		Address address = getById(AddressId);
		address.setCity(adr.getCity());
		address.setPincode(adr.getPinCode());
		address.setStreetArea(adr.getStreetArea());
		adrDao.save(address);

		return new ApiResponse("Address Updated Successfully....");

	}

	@Override
	public Address getById(Long AddressId) {
		Optional<Address> opt = adrDao.findById(AddressId);
		if (opt.isPresent())
			return opt.get();
		throw new ResourceNotFoundException("Address Not Found with Id: " + AddressId);
}
}