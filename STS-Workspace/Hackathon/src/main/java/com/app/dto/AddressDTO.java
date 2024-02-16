package com.app.dto;

import com.app.entities.City;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	
	private String streetArea;
	
	private City city;

	private int pinCode;

}
