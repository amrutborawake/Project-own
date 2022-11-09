package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dao.UsersDao;
import com.stackroute.model.Users;

@Service
public class UsersService {

	
	@Autowired
	UsersDao dao;
	
	//register user 
	 
		public Users addUsers(Users user){
		 Users u = dao.save(user);
			if(u!=null)
				return u;
			return null;
			
			
		}

		//fetch all users
		public List<Users> getAllUsers() {

			return dao.findAll();
		}
		
		
		// get user by id
		public Users getUser(int userId) {
			Optional<Users> u=dao.findById(userId);
			if(u.isPresent()) {
				return u.get();
			}else {
			return null;
			}
		}
	
		public Users updateUser(Users user) {
//			List<News> n=dao.getClass(news);
			Users u=dao.save(user);
			if(u!=null) 
			
			
			return u;
			else 
			return null;
			

		}
		
		//delete user by id
		public void deleteUser(int userId) {

			Optional<Users> u=dao.findById(userId);
			
			if(u.isPresent()) 
				dao.delete(u.get());
			
			
		
		}
		
		
		public boolean validate(Users u) {
			Users user = dao.findByUserNameAndPassword(u.getUserName(),u.getPassword());
			if(user!=null) {
				return true;
			}
			return false;
		}
		
       

}
