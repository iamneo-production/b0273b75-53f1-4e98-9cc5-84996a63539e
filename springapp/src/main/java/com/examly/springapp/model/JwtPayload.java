package com.examly.springapp.model;

public  class JwtPayload{
	public String username;
	public String password;
	JwtPayload(String username, String password) {
		this.username = username;
		this.password = password;
	}
	JwtPayload(){
		
	}
}
