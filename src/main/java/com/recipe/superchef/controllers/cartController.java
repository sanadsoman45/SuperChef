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

import com.recipe.superchef.entities.IngCart;
import com.recipe.superchef.services.cartService;

@RestController
@RequestMapping("/superchef")
public class cartController {

	@Autowired
	cartService crs;
	
	@PostMapping("/adding")
	public String insertIng(@RequestBody IngCart ingcart) {
		return crs.insertIng(ingcart);
	}
	
	@GetMapping("/getall/{emailId}")
	public List<IngCart> getallIng(@PathVariable("emailId") String emailId) {
		return crs.getallIng(emailId);
	}
	
	@GetMapping("/getingcart")
	public List<IngCart> getIngCart(@RequestBody IngCart ingcart) {
		return crs.getIngCart(ingcart);
	}
	
	@GetMapping("/ingcount/{emailId}")
	public Object getIngCount(@PathVariable("emailId") String emailId) {
		return crs.getIngCount(emailId);
	}
	
	@DeleteMapping("/ingclear/{emailId}")
	public String deleteAllIng(@PathVariable("emailId") String emailId) {
		return crs.deleteAllIng(emailId);
	}
	
	@DeleteMapping("/ingrem")
	public String deleteing(@RequestBody IngCart ingcart) {
		return crs.deleteIng(ingcart);
	}
	
	@GetMapping("/ingname")
	public List<IngCart> getIngByName(@RequestBody IngCart incart) {
		return crs.getIngByName(incart);
	}
	
	@GetMapping("/ising")
	public boolean checkIngByName(@RequestBody IngCart incart) {
		return crs.checkIngByName(incart);
	}
	
	@GetMapping("/iscartempty/{emailId}")
	public boolean isCartEmpty(@PathVariable("emailId") String emailId) {
		return crs.isCartEmpty(emailId);
	}
	
}
