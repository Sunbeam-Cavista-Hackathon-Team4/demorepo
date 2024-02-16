package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UnregisteredUserRegisterationDTO;
import com.app.entities.Gender;
import com.app.entities.Patient;
import com.app.entities.UnregisteredUser;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import com.app.service.PatientService;
import com.app.service.UnregisteredUsersService;
import com.app.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/unregistered_user")
public class UnregisteredController {
	@Autowired
	UnregisteredUsersService unregisteredUserService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;
	
	
	@PostMapping("/book_appointment")
	public ResponseEntity<?> registerNewAppointment(@RequestBody UnregisteredUserRegisterationDTO reg) {
		UnregisteredUser user=
				new UnregisteredUser(reg.getFirstName(),reg.getLastName(),reg.getEmail(),reg.getMobileNo(),reg.getDate(),reg.getTime(),false);
		UserEntity foundUser=userService.findByEmailAddress(reg.getEmail());
		if(foundUser==null) {
			unregisteredUserService.addUnregisteredUserRecord(user);
			UserEntity newUser=new UserEntity(user.getFirstName(),user.getLastName(),user.getEmail(),null,UserRole.ROLE_PATIENT,Gender.PREFER_NOT_TO_SAY,user.getMobileNo());
			userService.addNewUser(newUser);
			patientService.addPatient(new Patient(newUser));
			return ResponseEntity.status(HttpStatus.CREATED).body("Registered Appointment Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Already a User Please Login For Appointment");
		}
	}

}
