package com.recipe.superchef.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.superchef.dao.cartDao;
import com.recipe.superchef.entities.IngCart;

@Service
public class cartService {

	@Autowired
	cartDao cart;
	
	public String insertIng(IngCart ingcart) {
		return cart.insertIng(ingcart);
	}
	
	public List<IngCart> getallIng(String emailId) {
		return cart.getallIng(emailId);
	}

	public List<IngCart> getIngCart(IngCart ingcart) {
		// TODO Auto-generated method stub
		List<IngCart> inglist = cart.getallIng(ingcart.getEmailId());
		List<IngCart> ingnew = new ArrayList<>();
		for(IngCart item : inglist) {
			if(item.getIngtype().equalsIgnoreCase(ingcart.getIngtype())) {
				ingnew.add(item);
			}
		}
		return ingnew;
	}

	public Object getIngCount(String emailId) {
		return cart.getIngCount(emailId);
	}

	public String deleteAllIng(String emailId) {
		return cart.deleteAllIng(emailId);
	}

	public String deleteIng(IngCart ingcart) {
		return cart.deleteIng(ingcart);
	}

	public List<IngCart> getIngByName(IngCart ingcart) {
		List<IngCart> inglist = cart.getallIng(ingcart.getEmailId());
		List<IngCart> ingnew = new ArrayList<>();
		for(IngCart item : inglist) {
			if(item.getIngName().equalsIgnoreCase(ingcart.getIngName())) {
				ingnew.add(item);
			}
		}
		return ingnew;
	}

	public boolean checkIngByName(IngCart incart) {
		return cart.checkIngByName(incart);
	}

	public boolean isCartEmpty(String emailId) {
		boolean isEmpty = false;
		if(cart.getallIng(emailId).size() == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}
}
