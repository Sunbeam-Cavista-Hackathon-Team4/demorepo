package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.UnregisteredUser;
import com.github.javafaker.Faker;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UnregisteredUserDaoTest {
	
	@Autowired
	UnregisteredUserDao unregisteredUserDao;
	
	@Test
	void testAddUnregisteredUsers() {
		List<UnregisteredUser> list=new ArrayList<UnregisteredUser>();
		for(int i=0;i<20;i++) {
			Faker faker = new Faker(new Locale("en-IND"));
			UnregisteredUser user=new UnregisteredUser(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),
					faker.phoneNumber().cellPhone(),LocalDate.now(),LocalTime.now(),false);
			unregisteredUserDao.save(user);
			list.add(user);
		}
		assertEquals(20, list.size());
	}

}
