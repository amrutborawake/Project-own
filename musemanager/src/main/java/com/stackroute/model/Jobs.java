package com.stackroute.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;







@Entity
public class Jobs {

	@Id
	private int id;
	private String name;
	private String type;
	private LocalDate publication_date;
	private String short_name;
	private String landing_page;
	private String username;
	@ManyToOne
	private Users user;
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jobs(int id, String name, String type, LocalDate publication_date, String short_name, String landing_page,
			String username, Users user) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.publication_date = publication_date;
		this.short_name = short_name;
		this.landing_page = landing_page;
		this.username = username;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(LocalDate publication_date) {
		this.publication_date = publication_date;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getLanding_page() {
		return landing_page;
	}
	public void setLanding_page(String landing_page) {
		this.landing_page = landing_page;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", type=" + type + ", publication_date=" + publication_date
				+ ", short_name=" + short_name + ", landing_page=" + landing_page + ", username=" + username + ", user="
				+ user + "]";
	}
	
	
	
}