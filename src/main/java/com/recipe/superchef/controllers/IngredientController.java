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

import com.recipe.superchef.entities.Ingredients;
import com.recipe.superchef.services.IngredientService;

@RestController
@RequestMapping("/superchef")
public class IngredientController {
	
	@Autowired
	IngredientService ins;
	
	@PostMapping("/inserting")
	public String insertIng(@RequestBody Ingredients ing) {
		System.out.println(ing);
		return ins.insertIng(ing);
	}
	
	@GetMapping("/getalling/{emailId}")
	public List<Ingredients> getAllIng(@PathVariable("emailId") String emailId) {
		return ins.getAllIng(emailId);
	}
	
	@DeleteMapping("/deleteing")
	public String deleteIng(@RequestBody Ingredients ing) {
		return ins.deleteIng(ing);
	}
	
	@GetMapping("/geting")
	public List<Ingredients> getIng(@RequestBody Ingredients ing ) {
		return ins.getIng(ing);
	}
	
	@GetMapping("/ingcategory")
	public List<Ingredients> getIngbyCategory(@RequestBody Ingredients ing){
		return ins.getIngbyCategory(ing);
		
	}
	
	@GetMapping("/getcount/{emailId}")
	public Object getIngCount(@PathVariable("emailId") String emailId)
	{
		return ins.getIngCount(emailId);
	}

	@DeleteMapping("deleteall/{emailId}")
	public String deleteAll(@PathVariable("emailId") String emailId) {
		return ins.deleteAll(emailId);
	}
	
}
