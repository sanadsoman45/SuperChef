package com.recipe.superchef.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;


@Entity
@Component
public class FavRecipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favrecipeId",length = 100,nullable = false)
	private int favrecipeId;
	@Column(name = "userEmail", length = 100, nullable = false)
	private String emailId;
	@Column(name = "favrecipeName", length = 200, nullable = false)
	private String favrecipeName;
	@Column(name = "favimageUrl", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String favimageUrl;
	@Column(name = "favrecipeIng", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String favrecipeIng;
	@Column(name = "favrecipeInstr", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String favrecipeInstr;
	@Column(name = "favcookTime", length = 100)
	private String favcookTime;
	@Column(name = "favprepTime", length = 100)
	private String favprepTime;
	@Column(name = "favtotalTime", length = 100)
	private String favtotalTime;
	public int getFavrecipeId() {
		return favrecipeId;
	}
	public void setFavrecipeId(int favrecipeId) {
		this.favrecipeId = favrecipeId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFavrecipeName() {
		return favrecipeName;
	}
	public void setFavrecipeName(String favrecipeName) {
		this.favrecipeName = favrecipeName;
	}
	public String getFavimageUrl() {
		return favimageUrl;
	}
	public void setFavimageUrl(String favimageUrl) {
		this.favimageUrl = favimageUrl;
	}
	public String getFavrecipeIng() {
		return favrecipeIng;
	}
	public void setFavrecipeIng(String favrecipeIng) {
		this.favrecipeIng = favrecipeIng;
	}
	public String getFavrecipeInstr() {
		return favrecipeInstr;
	}
	public void setFavrecipeInstr(String favrecipeInstr) {
		this.favrecipeInstr = favrecipeInstr;
	}
	public String getFavcookTime() {
		return favcookTime;
	}
	public void setFavcookTime(String favcookTime) {
		this.favcookTime = favcookTime;
	}
	public String getFavprepTime() {
		return favprepTime;
	}
	public void setFavprepTime(String favprepTime) {
		this.favprepTime = favprepTime;
	}
	public String getFavtotalTime() {
		return favtotalTime;
	}
	public void setFavtotalTime(String favtotalTime) {
		this.favtotalTime = favtotalTime;
	}
	
	
	
}
