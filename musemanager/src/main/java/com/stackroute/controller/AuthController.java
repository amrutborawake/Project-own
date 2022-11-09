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

import com.stackroute.model.Users;
import com.stackroute.service.UsersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RestController
@CrossOrigin("*")
public class AuthController {
	
	
	ResponseEntity<?> response;
	@Autowired
	UsersService service;
	boolean flag;
	@Autowired
	HttpSession session;
	
	String token = "";
	static final long EXPIRATIONTIME=2000; //setting expiration time for user token
	
	
	
	//register user method
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Users u) {
		flag = service.addUsers(u) != null;
		if(flag) {
			response = new ResponseEntity<String>("Register Sucessfully",HttpStatus.CREATED);
			
		}
		else {
			response = new ResponseEntity<String>("Failure! Check the code",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	
	//login user method
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Users u,HttpSession session){
		flag = service.validate(u);
		if(flag) {
			session.setAttribute("password", u.getPassword());
			token = getToken(u.getUserName());
//			String username=u.getUserName();
			response = new ResponseEntity<String>(token,HttpStatus.OK);
			
			
			
//			 return response=new ResponseEntity<String>(username,HttpStatus.OK);
			
		}
		else {
			response = new ResponseEntity<String>("Failure! No Records",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	//logout user method 
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		
		String p = (String)session.getAttribute("password");
		System.out.print(p);//		String userName = (String)session.getAttribute("userName");
		if(p!="") {
			session.invalidate();
			
			response = new ResponseEntity<String>("Logged Out Succesfully",HttpStatus.OK);
			System.out.print(p);
		}
		else {
			response = new ResponseEntity<String>("Please Login",HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	//generating token for user
	private String getToken(String userName) {
		String jwtToken = Jwts.builder()
			.setSubject(userName)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
			.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		
		System.out.println("Token "+jwtToken);
		return jwtToken;
	}

	
	

	
	

}
