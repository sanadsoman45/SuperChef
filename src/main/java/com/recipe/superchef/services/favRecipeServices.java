package com.recipe.superchef.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.superchef.dao.favRecipeDao;
import com.recipe.superchef.entities.FavRecipes;
import com.recipe.superchef.entities.Recipes;


@Service
public class favRecipeServices {

	@Autowired
	favRecipeDao recipeDao;
	
	@Autowired
	recipeService rservice;
	
	@Autowired
	FavRecipes favrecipe;
	
	public String addRecipe(String emailId, String recipeName) {
		
		List<Recipes> lst = rservice.getRecipeByName(recipeName);
		favrecipe.setEmailId(emailId);
		for(Recipes recipe: lst) {
			favrecipe.setFavcookTime(recipe.getCookTime());
			favrecipe.setFavimageUrl(recipe.getImageUrl());
			favrecipe.setFavprepTime(recipe.getPrepTime());
			favrecipe.setFavrecipeIng(recipe.getRecipeIng());
			favrecipe.setFavrecipeInstr(recipe.getRecipeInstr());
			favrecipe.setFavrecipeName(recipe.getRecipeName());
			favrecipe.setFavtotalTime(recipe.getTotalTime());
		}
		return recipeDao.addRecipe(favrecipe);
	}

	public String removeRecipeByName(FavRecipes favrecipes) {
		return recipeDao.removeRecipeByName(favrecipes);
	}

	public List getCountRecipes(String emailId) {
		return recipeDao.getCountRecipes(emailId);
	}

	public List<FavRecipes> getAllFavRecipes(String emailId) {
		return recipeDao.getAllFavRecipes(emailId);
	}

	public List<FavRecipes> getFavRecipe(FavRecipes favrecipes) {
		List<FavRecipes> favrecipelist = recipeDao.getAllFavRecipes(favrecipes.getEmailId());
		List<FavRecipes> favlist = new ArrayList<>();
		for(FavRecipes recipe: favrecipelist) {
			if(recipe.getFavrecipeName().equalsIgnoreCase(favrecipes.getFavrecipeName())) {
				favlist.add(recipe);
			}
		}
		return favlist;
	}

	public List<FavRecipes> getFavRecipeByIng(FavRecipes favrecipes) {
		List<FavRecipes> recipelst = recipeDao.getAllFavRecipes(favrecipes.getEmailId());
		List<FavRecipes> lstnew = new ArrayList<>();
		for(FavRecipes recipe: recipelst) {
			if(recipe.getFavrecipeIng().toLowerCase().contains(favrecipes.getFavrecipeIng().toLowerCase())) {
				lstnew.add(recipe);
			}
		}
		return lstnew;
	}

	public String deleteAllFavRecipes(String emailId) {
		// TODO Auto-generated method stub
		return recipeDao.deleteAllFavRecipes(emailId);
	}

}
