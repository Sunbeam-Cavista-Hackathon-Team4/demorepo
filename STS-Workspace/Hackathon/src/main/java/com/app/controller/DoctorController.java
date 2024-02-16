package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RegisterPatientDTO;
import com.app.service.DoctorService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorservice ;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDoctors(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(new RegisterPatientDTO());
	}

}
