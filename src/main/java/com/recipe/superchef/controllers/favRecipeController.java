package com.recipe.superchef.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.superchef.entities.FavRecipes;
import com.recipe.superchef.services.favRecipeServices;

@RestController
@RequestMapping("/superchef")
public class favRecipeController {
	
	@Autowired
	favRecipeServices recipeService;
	
	@PostMapping("/addfavrecipe/{emailId}/recipename/{recipeName}")
	public String addRecipe(@PathVariable("emailId") String emailId,@PathVariable("recipeName") String recipeName) {
		
		return recipeService.addRecipe(emailId,recipeName);
		
	}
	
	@DeleteMapping("delfavrecipe")
	public String removeRecipeByName(@RequestBody FavRecipes favrecipe) {
		return recipeService.removeRecipeByName(favrecipe);
	}
	
	@GetMapping("/countrecipes/{emailId}")
	public List getCountRecipes(@PathVariable("emailId") String emailId) {
		return recipeService.getCountRecipes(emailId);
	}
	
	@GetMapping("/getallfav/{emailId}")
	public List<FavRecipes> getAllFavRecipes(@PathVariable("emailId") String emailId) {
		return recipeService.getAllFavRecipes(emailId);
	}
	
	@GetMapping("/getfavrecipe")
	public List<FavRecipes> getFavRecipe(@RequestBody FavRecipes favrecipes) {
		return recipeService.getFavRecipe(favrecipes);
	}
	
	@GetMapping("/getfavrecipeing")
	public List<FavRecipes> getFavRecipeByIng(@RequestBody FavRecipes favrecipes){
		return recipeService.getFavRecipeByIng(favrecipes);
	}
	
	@DeleteMapping("/remallrecipes/{emailId}")
	public String deleteAllFavRecipes(@PathVariable("emailId") String emailId) {
		return recipeService.deleteAllFavRecipes(emailId);
	}
}
