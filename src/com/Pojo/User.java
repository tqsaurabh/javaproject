package com.Pojo;
public class User {
	private String uname;
	private String gender;
	private String password;
	private long mobileno;
	private String email;
	private String address;
	
	public User()
	{
		
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String uname, String gender, String password, long mobileno, String email, String address) {
		
		this.uname = uname;
		this.gender = gender;
		this.password = password;
		this.mobileno = mobileno;
		this.email = email;
		this.address = address;
	}

	
	}
