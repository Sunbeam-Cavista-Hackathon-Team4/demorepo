package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDTO;
import com.app.entities.City;
import com.app.dto.RegisterPatientDTO;

import com.app.service.DoctorService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService ;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDoctors(){
		List<DoctorDTO> list= doctorService.getAllDoctor();
		if(list.isEmpty())
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(list);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addDoctor(@RequestBody DoctorDTO doctorDto ){
		
		return  ResponseEntity.status(HttpStatus.OK).body(doctorService.addDoctor(doctorDto));
	}
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<?> getDoctorbyId(@PathVariable Long doctorId){
		return ResponseEntity.status(HttpStatus.OK).body(doctorService.getDoctorbyId(doctorId));
	}
	
	@GetMapping("/{city}")
	public ResponseEntity<?> getDoctorbyCity(@PathVariable City city){
		List<DoctorDTO> list = doctorService.getDoctorByCity(city);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(list);
	}
	
	
	

}