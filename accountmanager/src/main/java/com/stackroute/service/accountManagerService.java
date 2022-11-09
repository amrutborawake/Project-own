package com.stackroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dao.AccountManager;

import com.stackroute.model.accountManager;

@Service
public class accountManagerService implements accountManagerException{
	
	@Autowired
	AccountManager dao;   

	
	//add manager method
	
	public accountManager addManager(accountManager manager) {
		accountManager m = dao.save(manager);
			if(m!=null)
				return m;
			return null;
			
			
		}
	
	
	//validating login of manager
	public boolean validate(accountManager m) {
		accountManager managers = dao.findByManagerNameAndPassword(m.getManagerName(),m.getPassword());
		if(managers!=null) {
			return true;
		}
		return false;
	}
}
