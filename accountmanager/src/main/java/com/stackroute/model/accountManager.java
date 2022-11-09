package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity class for account manager and setters getters

@Entity
public class accountManager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  //generating auto value primary key
	private int managerId;
	private String managerName;
	private String password;
	public accountManager() {
		super();
	
	}
	public accountManager(int managerId, String managerName, String password) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.password = password;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "accountManager [managerId=" + managerId + ", managerName=" + managerName + ", password=" + password
				+ "]";
	}
	
	
	
}
