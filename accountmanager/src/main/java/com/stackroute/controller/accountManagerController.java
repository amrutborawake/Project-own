package com.stackroute.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.stackroute.model.accountManager;
import com.stackroute.service.accountManagerService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin("*")     //cross mapping to allow all request
public class accountManagerController {

	
	ResponseEntity<?> response;
	@Autowired
	accountManagerService service;
	boolean flag;
	

	
	String adminToken = "";
	static final long EXPIRATIONTIME=20000; //Seeting expiration time for token
	
	
	//adding manager method
	
	@PostMapping("/addManager")
	public ResponseEntity<?> addManager(@RequestBody accountManager m) {
		flag = service.addManager(m) != null;
		if(flag) {
			response = new ResponseEntity<String>("admin Added",HttpStatus.CREATED);
		}
		else {
			response = new ResponseEntity<String>("Failure! Check the code",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	//login manager method
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody accountManager m,HttpSession session){
		flag = service.validate(m);
		if(flag) {
			session.setAttribute("password", m.getPassword());
			adminToken = getToken(m.getManagerName());

			response = new ResponseEntity<String>(adminToken,HttpStatus.OK);
			
			
			

			
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	//logout manager method
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		String password = (String)session.getAttribute("password");
		String managerName = (String)session.getAttribute("managerName");
		if(password!="" && managerName!="") {
			session.invalidate();
			
			response = new ResponseEntity<String>("Logged Out Succesfully",HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Please Login",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	//Generating token for manager
	
	private String getToken(String managerName) {
		String jwtToken = Jwts.builder()
			.setSubject(managerName)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
			.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		
//		System.out.println("Token "+jwtToken);
		return jwtToken;
	}
	
	
}
