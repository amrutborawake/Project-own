package com.stackroute.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stackroute.dao.UsersDao;
import com.stackroute.model.Users;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersServiceTest {

	@Autowired
	UsersDao dao;
	
	

	@Test
	@Order(1)
	void testGetAllUsers() {
		 
		List<Users> user=dao.findAll();
		assertThat(user.size()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	void testGetUser() {
		Users user=dao.findById(32).get();
		Assertions.assertThat(user.getUserId()).isEqualTo(32);
		
	}

	@Test
	@Order(3)
	void testUpdateUser() {
		Users user=dao.findById(33).get();
		user.setEmaiAddress("sid123@gmail.com");
		Users u=dao.save(user);
		assertThat(user.getEmaiAddress()).isEqualTo("sid123@gmail.com");
	}

	@Test
	@Order(4)
	void testDeleteUser() {
		Users user=dao.findById(36).get();
		dao.delete(user);
//		Users user1=null;
//		Optional<Users> u=dao.findByEmaiAddress("ritik@gmail.com");
//		
//		if(u.isPresent()) {
//			user1=u.get();
//		}
		boolean user2=dao.findById(36).get() != null;
		assertThat(user2).isTrue();
	}

	@Test
	@Order(5)
	void testValidate() {
		boolean actualResult=dao.findByUserNameAndPassword("amrut", "root123") != null;
		assertThat(actualResult).isTrue();
		
	}

}
