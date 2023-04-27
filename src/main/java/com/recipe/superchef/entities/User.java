package com.recipe.superchef.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	@Column(name = "user_name", nullable = false,length =100)
	private String name;
	@Id
	@Column(name = "user_email", nullable = false,length =100)
	private String email;
	@Column(name = "user_passwd", nullable = false,length =100)
	private String  passwd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
