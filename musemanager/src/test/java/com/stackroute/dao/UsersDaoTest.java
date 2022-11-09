package com.stackroute.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stackroute.model.Users;
@SpringBootTest
class UsersDaoTest {
@Autowired 
UsersDao dao;
	@Test
	void testFindByUserNameAndPassword() {
//		Users u=new Users(12,"ritk","ritik@gmail.com","root123", null);
//		dao.save(u);
		boolean actualResult=dao.findByUserNameAndPassword("amrut", "root123") != null;
		assertThat(actualResult).isTrue();
	}
	
	

}
