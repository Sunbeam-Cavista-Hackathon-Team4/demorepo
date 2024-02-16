package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnregisteredUserRegisterationDTO {
	@NotBlank(message = "First Name Required !")
	private String firstName;
	@NotBlank(message = "Last Name Required !")
	private String lastName;
	@NotBlank(message = "Email Required !")
	private String email;
	@NotBlank(message = "Mobile No Required !")
	private String mobileNo;
	@NotBlank(message = "Date Required !")
	private LocalDate date;
	@NotBlank(message = "Time Required !")
	private LocalTime time;
}
