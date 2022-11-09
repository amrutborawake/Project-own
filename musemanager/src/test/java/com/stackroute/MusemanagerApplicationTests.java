package com.stackroute;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.stackroute.controller.UsersController;

@SpringBootTest
class MusemanagerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	ResponseEntity<?> response;
	@Autowired
UsersController contoller;
	
	@Before
	public void  setUp() {
		contoller=new UsersController();
	}
	@After
	public void tearDown() {
		
		contoller=null;
		
	}
	@Test
	public void getAllusersTest() {

		response=(ResponseEntity<?>) contoller.getAllusers().ok();
		
		assertEquals(response,contoller.getAllusers());
		
	}
	

}
