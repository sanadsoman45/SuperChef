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
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipeId",length = 100,nullable = false)
	private int recipeId;
	@Column(name = "recipeName", length = 200, nullable = false)
	private String recipeName;
	@Column(name = "imageUrl", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String imageUrl;
	@Column(name = "recipeIng", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String recipeIng;
	@Column(name = "recipeInstr", length = 65535, columnDefinition="TEXT",nullable = false)
	@Type(type="text")
	private String recipeInstr;
	@Column(name = "cookTime", length = 100)
	private String cookTime;
	@Column(name = "prepTime", length = 100)
	private String prepTime;
	@Column(name = "totalTime", length = 100)
	private String totalTime;
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
//	public String getEmailId() {
//		return emailId;
//	}
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getRecipeIng() {
		return recipeIng;
	}
	public void setRecipeIng(String recipeIng) {
		this.recipeIng = recipeIng;
	}
	public String getRecipeInstr() {
		return recipeInstr;
	}
	public void setRecipeInstr(String recipeInstr) {
		this.recipeInstr = recipeInstr;
	}
	public String getCookTime() {
		return cookTime;
	}
	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}
	public String getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	
	
	
	
}
