package com.app.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Category;
import com.app.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientDTO {

	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String phoneNo;
	
	private LocalDateTime registrationCall;

	
}
