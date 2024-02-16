package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.app.entities.UserEntity;
import com.app.entities.UserRole;
import com.github.javafaker.Faker;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserEntityDaoTest {
	
	@Autowired
	private UserEntityDao userRepo;

	@Autowired
	private PasswordEncoder enc;

	@Test
	void testAddUsers() {
//		List<UserEntity> list=new ArrayList<UserEntity>();
//		for(int i=0;i<20;i++) {
//			Faker faker = new Faker(new Locale("en-IND"));
//			UserEntity user=new UserEntity(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),enc.encode(faker.animal().name()),UserRole.ROLE_PATIENT);
//			userRepo.save(user);
//			list.add(user);
//		}
//		assertEquals(20, list.size());
	}

}
