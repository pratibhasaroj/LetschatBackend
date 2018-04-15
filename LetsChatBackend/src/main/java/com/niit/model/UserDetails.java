package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserDetails {

	@Id
	@Column(name = "loginname")
	private String loginname;

	@Column(name = "password")
	private String password;

	@Column(name="username")
	private String username;
	
	@Column(name = "emailid")
	private String emailId;

	@Column(name = "mobileNo")
	String mobileNo;

	@Column(name = "address")
	String address;

	@Column(name = "role")
	private String role;

	@Column(name="isOnline")
	private String isOnline;
	
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	
	
}
