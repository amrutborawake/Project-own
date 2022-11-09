package com.stackroute.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;






@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String emaiAddress;
	private String password;
	@OneToMany
	private List<Jobs> jobs;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String userName, String emaiAddress, String password, List<Jobs> jobs) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emaiAddress = emaiAddress;
		this.password = password;
		this.jobs = jobs;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmaiAddress() {
		return emaiAddress;
	}
	public void setEmaiAddress(String emaiAddress) {
		this.emaiAddress = emaiAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Jobs> getJobs() {
		return jobs;
	}
	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", emaiAddress=" + emaiAddress + ", password="
				+ password + ", jobs=" + jobs + "]";
	}
	
	
	

}