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

import com.recipe.superchef.entities.Recipes;
import com.recipe.superchef.services.recipeService;

@RestController
@RequestMapping("/superchef")
public class recipeController {
	
	@Autowired
	recipeService rs;
	
	@PostMapping("/addrecipe")
	public String insertRecipes(@RequestBody Recipes recipes) {
		return rs.insertRecipes(recipes);
	}
	
	@GetMapping("/count")
	public List getCountRecipes() {
		return rs.getCountRecipes();
	}
	
	@GetMapping("/getall")
	public List<Recipes> getAllRecipes(){
		return rs.getAllRecipes();
	}
	
	@GetMapping("/getrecipe/{recipeName}")
	public List<Recipes> getRecipeByName(@PathVariable("recipeName") String recipeName){
		return rs.getRecipeByName(recipeName);
	}
	
	@GetMapping("/getrecipeing/{ingName}")
	public List<Recipes> getRecipeByIng(@PathVariable("ingName") String ingName){
		return rs.getRecipeByIng(ingName);
	}
	
	@DeleteMapping("/remrecipe/{recipeName}")
	public String deleteRecipe(@PathVariable("recipeName") String recipeName) {
		return rs.deleteRecipe(recipeName);	}
	
	@GetMapping("/getcooktime/{recipeName}")
	public String getCookTime(@PathVariable("recipeName") String recipeName) {
		return rs.getCookTime(recipeName);
	}
	
//	@GetMapping("/starttime/{startTime}/endtime/{endTime}")
//	public void getCookTimebetween(@PathVariable("startTime") String startTime,@PathVariable("endTime") String endTime) {
//		return rs.getCookTimebetween(startTime,endTime);
//	}
}
