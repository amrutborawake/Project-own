package com.stackroute.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stackroute.model.accountManager;
@Repository 
public interface AccountManager extends JpaRepository<accountManager, Integer> {
	// method which will find user by name and password for login
	
	public accountManager findByManagerNameAndPassword(String managerName,String password);

}
