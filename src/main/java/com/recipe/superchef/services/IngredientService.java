package com.recipe.superchef.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.superchef.dao.IngredientDao;
import com.recipe.superchef.dao.UserDao;
import com.recipe.superchef.entities.Ingredients;

@Service
public class IngredientService {

	@Autowired
	IngredientDao ingdao;
	
	public String insertIng(Ingredients ing) {
		return ingdao.insertIng(ing);
	}

	public List<Ingredients> getAllIng(String emailId) {
		// TODO Auto-generated method stub
		return ingdao.getAllIng(emailId);
	}

	

	public String deleteIng(Ingredients ing) {

		return ingdao.deleteIng(ing);
	}

	public List<Ingredients> getIng(Ingredients ing) {
		List<Ingredients> inglst = ingdao.getAllIng(ing.getEmailId());
		List<Ingredients> ingnew = new ArrayList<>();
		for (Ingredients ingele : inglst) {
			if (ingele.getIngName().equalsIgnoreCase(ing.getIngName())) {
				ingnew.add(ingele);
			}
		}
		return ingnew;
	}

	public List<Ingredients> getIngbyCategory(Ingredients ing) {
		List<Ingredients> inglst = ingdao.getAllIng(ing.getEmailId());
		List<Ingredients> ingnew = new ArrayList<>();
		for (Ingredients ingele : inglst) {
			if (ingele.getCategory().equalsIgnoreCase(ing.getCategory())) {
				ingnew.add(ingele);
			}
		}
		return ingnew;
	}

	public Object getIngCount(String emailId) {
		// TODO Auto-generated method stub
		return ingdao.getIngCount(emailId);
	}

	public String deleteAll(String emailId) {
		return ingdao.deleteAll(emailId);
	}
	

}
