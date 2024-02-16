package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PatientDetailDTO;
import com.app.entities.Patient;
import com.app.service.AdminService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/new")
	public List<PatientDetailDTO> getUnregisteredPatients() {
		return adminService.getUnregisteredPatients();
	}
	
	@PostMapping("/update")
	public ApiResponse updateDetails(@RequestBody PatientDetailDTO details) {
		return adminService.updateDetails(details);
	}
	
}
