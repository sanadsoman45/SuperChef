package com.recipe.superchef.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.superchef.dao.recipeDao;
import com.recipe.superchef.entities.Recipes;

@Service

public class recipeService {

	@Autowired
	recipeDao rdao;
	
	public String insertRecipes(Recipes recipes) {
		// TODO Auto-generated method stub
		return rdao.insertRecipes(recipes);
	}

	public List getCountRecipes() {
		return rdao.getCountRecipes();
	}

	public List<Recipes> getAllRecipes() {
		// TODO Auto-generated method stub
		return rdao.getAllRecipes();
	}

	public List<Recipes> getRecipeByName(String recipeName) {
		List<Recipes> recipelst = rdao.getAllRecipes();
		List<Recipes> lstnew = new ArrayList<>();
		for(Recipes recipe: recipelst) {
			if(recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
				lstnew.add(recipe);
			}
		}
		return lstnew;
	}

	public List<Recipes> getRecipeByIng(String ingName) {
		List<Recipes> recipelst = rdao.getAllRecipes();
		List<Recipes> lstnew = new ArrayList<>();
		for(Recipes recipe: recipelst) {
			if(recipe.getRecipeIng().toLowerCase().contains(ingName.toLowerCase())) {
				lstnew.add(recipe);
			}
		}
		return lstnew;
	}

	public String deleteRecipe(String recipeName) {
		return rdao.deleteRecipe(recipeName);
	}

	public String getCookTime(String recipeName) {
		// TODO Auto-generated method stub
		List<Recipes> recipelst = rdao.getAllRecipes();
		String msg = "Recip not found.";
		for(Recipes recipe: recipelst) {
			
			if(recipe.getRecipeName().toLowerCase().equals(recipeName.toLowerCase())) {
				msg = "Cook Time for the recipe is:"+recipe.getCookTime()+" Total time is: "+recipe.getTotalTime()+" Preparation time is:"+recipe.getPrepTime();
			}
			
		}
		
		return msg;
	}

//	public Object getCookTimebetween(String startTime, String endTime) {
//		List<Recipes> recipelst = rdao.getAllRecipes();
//		List<Recipes> newlst = new ArrayList<>();
//		String starttime[] = startTime.split(" ");
//		String dataTime[];
//		for(Recipes recipe: recipelst) {
//			dataTime = recipe.getCookTime().split(" ");
//			if()
//			
//		}
//	}

}
