package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Address;
import com.app.entities.Category;
import com.app.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetailDTO {
	
private String firstName;
	
	private String lastName;

	private String email;
	
	private Gender gender;
	
	private LocalDate dob;

	private Category category;
	
	private Address address;
	
	private String mobileNo;

}
