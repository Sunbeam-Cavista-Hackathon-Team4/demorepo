package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	@Column(length = 20,nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	
	private UserRole userRole;
	
	private UserValidity validity;
	

	
	
}
