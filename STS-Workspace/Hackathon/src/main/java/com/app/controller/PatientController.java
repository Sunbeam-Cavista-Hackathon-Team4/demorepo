package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDTO;
import com.app.service.PatientService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPatients(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(new PatientDTO());
	}
	
	
	

}
