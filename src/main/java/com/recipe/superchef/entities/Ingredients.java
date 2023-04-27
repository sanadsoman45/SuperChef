package com.recipe.superchef.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

	@Id
	@Column(name = "ing_id",nullable = false,length = 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ingId;
	@Column(name = "email_id",nullable = false,length = 100)
	private String emailId;
	@Column(name = "ing_name",nullable = false,length = 100)
	private String ingName;
	@Column(name = "category", nullable = false,length = 100)
	private String category;
	public int getIngId() {
		return ingId;
	}
	public void setIngId(int ingId) {
		this.ingId = ingId;
	}
	@Override
	public String toString() {
		return "Ingredients [ingId=" + ingId + ", emailId=" + emailId + ", ingName=" + ingName + ", category="
				+ category + "]";
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
	
	
	
}
