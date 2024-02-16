package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	@Column
	private String email;
	
	@Column(length = 20,nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	
	@Column(length = 20,nullable = false)
	private UserRole userRole;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20,nullable = false)
	private UserValidity validity;
	

	
	
}
