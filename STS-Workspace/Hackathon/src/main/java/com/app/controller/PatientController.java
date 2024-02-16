package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PatientDetailDTO;
import com.app.dto.RegisterPatientDTO;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.security.JwtUtils;
import com.app.service.PatientService;
import com.app.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager mgr;

	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPatients(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(new RegisterPatientDTO());
	}
	@PostMapping("/register")
	public ResponseEntity<?> addPatient(@RequestBody RegisterPatientDTO patient){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(patientService.addNewPatient(patient));
	}
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SigninRequest reqDTO) {
		System.out.println("in signin " + reqDTO);
		// simply invoke authentucate(...) on AuthMgr
		// i/p : Authentication => un verifed credentials
		// i/f --> Authentication --> imple by UsernamePasswordAuthToken
		// throws exc OR rets : verified credentials (UserDetails i.pl class: custom
		// user details)

		Authentication verifiedAuth = mgr
				.authenticate(new UsernamePasswordAuthenticationToken
						(reqDTO.getEmail(), reqDTO.getPassword()));
		System.out.println(verifiedAuth.getClass());// Custom user details
		// => auth success
		return ResponseEntity
				.ok(new SigninResponse(utils.generateJwtToken(verifiedAuth), "Successful Authentication!!!"));

	}
	
	@PutMapping("/changepassword/{patient_id}")
	public ResponseEntity<?> changePassword(@PathVariable Long patient_id,@RequestBody String password){
		return ResponseEntity.status(HttpStatus.OK).body(patientService.changePassword(patient_id,password));
	}
	
	
	

}
