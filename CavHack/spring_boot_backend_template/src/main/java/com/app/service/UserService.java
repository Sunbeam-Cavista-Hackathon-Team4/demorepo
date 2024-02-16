package com.app.service;

import com.app.dto.SignInDTO;
import com.app.dto.SigninRequest;
import com.app.dto.Signup;
import com.app.entities.UserEntity;

public interface UserService {
//sign up
	
	
	UserEntity findByEmailAddress(String email);
	
	SignInDTO signIn(SigninRequest dto);
}
