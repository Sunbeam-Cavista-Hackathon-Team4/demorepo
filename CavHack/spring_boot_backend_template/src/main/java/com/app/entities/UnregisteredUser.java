package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@ToString
@Entity
@Table(name="unregistered_users")
public class UnregisteredUser extends BaseEntity{
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 100, unique = true)
	private String email;
	@Column(length = 15)
	private String mobileNo;
	@Column
	private LocalDate date;
	@Column
	private LocalTime time;
	@Column(name="is_registered")
	private boolean isRegistered;
}
