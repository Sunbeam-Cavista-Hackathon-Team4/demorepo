package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UnregisteredUser;

public interface UnregisteredUserDao extends JpaRepository<UnregisteredUser, Long>{

	List<UnregisteredUser> findByIsRegisteredIsFalse();

}
