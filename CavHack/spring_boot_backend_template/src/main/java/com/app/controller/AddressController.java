package com.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.service.AddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService adrService;

	@PostMapping("/{patientId}")
	public ResponseEntity<?> assignAddressToPatient(
			@PathVariable @NotNull(message = "Patient id is required !!!") Long patientId,
			@RequestBody AddressDTO adr) {
		System.out.println("in assign adr " + adr);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(adrService.assignPatientAddress(patientId, adr));
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping("/{addressId}")
	public ResponseEntity<?> updatePatientAddress(
			@PathVariable @NotNull(message = "Address id is required !!!") Long addressId,
			@RequestBody AddressDTO adr) {
		System.out.println("in assign adr " + adr);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adrService.updateAddress(addressId, adr));

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
		
	@GetMapping("/{addressId}")
	public ResponseEntity<?> GetAddressId(@PathVariable @NotNull(message = "Address id is required !!!") Long addressId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adrService.getById(addressId));

		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	
	}

	
}
