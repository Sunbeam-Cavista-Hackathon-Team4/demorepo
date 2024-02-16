package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString
@Table(name="unregistered_users")
public class UnregisteredUser {
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 100, unique = true)
	private String email;
	@Column(length = 15)
	private String mobileNo;
	@Column(name="is_registered")
	private boolean isRegistered;
}
