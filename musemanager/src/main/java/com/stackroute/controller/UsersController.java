package com.stackroute.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Users;
import com.stackroute.service.UsersService;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/admin/")
@CrossOrigin("*")

public class UsersController {

	
	ResponseEntity<?> response;
	@Autowired
	UsersService service;
	boolean flag;
	
	
	//fetching all the users
	
	@GetMapping("/getAllusers")
	public ResponseEntity<?> getAllusers(){
		
		List<Users> userList = service.getAllUsers();
		if(userList!=null) {
			response = new ResponseEntity<List<Users>>(userList,HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
	}
	
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") int uId) {

		Users u = null;
		
			u = service.getUser(uId);
		
		if(u!=null) {
			response = new ResponseEntity<Users>(u,HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
		
	}
	

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody Users user,HttpSession session) {

		if(user!=null) {
			service.updateUser(user);
			response = new ResponseEntity<String>("User has been updated",HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
		
	}
	
	// deleting user by userId
	@DeleteMapping("/DeleteTheUser/{userId}")
	public ResponseEntity<?> DeleteTheUser(@PathVariable("userId") int uId,HttpSession session) {

		Users u = null;
		try {
			u = service.getUser(uId);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(u!=null) {
			service.deleteUser(uId);
			response = new ResponseEntity<String>("User has been Deleted",HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}

		return response;
		
	}
	
	
	
	
	
}