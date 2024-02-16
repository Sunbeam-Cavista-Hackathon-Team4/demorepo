package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SignInDTO;
import com.app.dto.SigninRequest;
import com.app.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserEntityController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> signIn(@RequestBody SigninRequest req) {
		return ResponseEntity.ok(userService.signIn(req));
	}
	

}
