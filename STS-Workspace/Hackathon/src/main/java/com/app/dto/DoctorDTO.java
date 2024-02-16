package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Availability;
import com.app.entities.Gender;
import com.app.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

	
	private LocalDate dob;

	private Gender gender;

	private String qualification;

	private LocalDate joinDate;

	private String mobileNo;

	private Availability availability;

	private UserEntity user;

}
