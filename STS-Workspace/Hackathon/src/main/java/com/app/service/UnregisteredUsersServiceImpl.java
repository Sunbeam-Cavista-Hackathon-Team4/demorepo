package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UnregisteredUserDao;
import com.app.entities.UnregisteredUser;

@Service
@Transactional
public class UnregisteredUsersServiceImpl implements UnregisteredUsersService {
	
	@Autowired
	UnregisteredUserDao unregisteredUserDao;

	@Override
	public UnregisteredUser addUnregisteredUserRecord(UnregisteredUser u) {
		UnregisteredUser user=unregisteredUserDao.save(u);
		return user;
	}

}
