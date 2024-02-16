package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entities.Category;
import com.app.entities.Gender;

public class PatientDTO {

	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private Gender gender;

	private Category category;
}
