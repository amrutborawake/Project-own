package com.stackroute.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.model.Users;
@Repository 
public interface UsersDao extends JpaRepository<Users, Integer>{
	
	public Users findByUserNameAndPassword(String userName,String password);
	Optional<Users> findByEmaiAddress(String emaiAddress);
	

}
