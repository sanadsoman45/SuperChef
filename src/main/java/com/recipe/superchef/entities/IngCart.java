package com.recipe.superchef.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IngCart {
	
	@Id
	@Column(name = "cartid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartIngId;
	@Column(name = "emailid", length = 100)
	private String emailId;
	@Column(name = "ingname", length = 100)
	private String ingName;
	@Column(name = "ingtype", length = 100)
	private String ingtype;
	
	public int getCartIngId() {
		return cartIngId;
	}
	public void setCartIngId(int cartIngId) {
		this.cartIngId = cartIngId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getIngName() {
		return ingName;
	}
	public void setIngName(String ingName) {
		this.ingName = ingName;
	}
	public String getIngtype() {
		return ingtype;
	}
	public void setIngtype(String ingtype) {
		this.ingtype = ingtype;
	}
	
	

}
