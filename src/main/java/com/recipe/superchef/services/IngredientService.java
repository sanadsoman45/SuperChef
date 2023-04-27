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

	public List<Ingredients> getAllIng(String emailId) {
		// TODO Auto-generated method stub
		return ingdao.getAllIng(emailId);
	}

	public String insertIng(Ingredients ing) {
		List<Ingredients> inglst = ingdao.getAllIng(ing.getEmailId());
		List<Ingredients> ingnew = new ArrayList<>();
		String msg = "";
		System.out.println(inglst);
		if (inglst.size() == 0) {
			System.out.println("outside if");
			msg = ingdao.insertIng(ing);
		} else {
			for (Ingredients ingele : inglst) {
				System.out.println(ingele.getIngName().contains(ing.getIngName()));
				System.out.println(!ingele.getIngName().contains(ing.getIngName()));
				if (ingele.getIngName().contains(ing.getIngName()) == false) {
					System.out.println("inside if");
					msg = ingdao.insertIng(ing);
				} else {
					System.out.println("inside else");
					msg = "Ingredient is already added.";
				}
			}
		}

		return msg;
	}

	public String deleteIng(Ingredients ing) {

		return ingdao.deleteIng(ing);
	}

	public List<Ingredients> getIng(Ingredients ing) {
		List<Ingredients> inglst = ingdao.getAllIng(ing.getEmailId());
		List<Ingredients> ingnew = new ArrayList<>();
		for (Ingredients ingele : inglst) {
			if (ingele.getIngName().contains(ing.getIngName())) {
				ingnew.add(ingele);
			}
		}
		return ingnew;
	}

	public List<Ingredients> getIngbyCategory(Ingredients ing) {
		List<Ingredients> inglst = ingdao.getAllIng(ing.getEmailId());
		List<Ingredients> ingnew = new ArrayList<>();
		for (Ingredients ingele : inglst) {
			if (ingele.getIngName().contains(ing.getCategory())) {
				ingnew.add(ingele);
			}
		}
		return ingnew;
	}

}
