package com.recipe.superchef.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.superchef.Exceptions.ResourceNotFoundException;
import com.recipe.superchef.dao.UserDao;
import com.recipe.superchef.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public String userLogin(User user) {
		// TODO Auto-generated method stub
		List<User> user_lst = userdao.getUserbyEmailId(user.getEmail());
		String msg = "Account Not Registered.";
		if(user_lst.size()!=0) {
			
			for(User useritem: user_lst) {
				if(useritem.getPasswd().equals(user.getPasswd())) {
					msg = "Login Successful";
				}
				else {
					msg = "Invalid Credentials";
				}
			}
			
		}
		
		return msg;
	}
	
	public String createUser(User user) {
		List<User> user_lst = userdao.getUserbyEmailId(user.getEmail());
		String msg = "";
		if (user_lst.size() == 0) {

			msg = userdao.createUser(user);

		} else {
			msg = "Email id already exists";
		}
		return msg;

	}

	public String updateUser(User user) {

		return userdao.updateUser(user);

	}

	public String deleteUser(String emailId) {

		List<User> user_lst = userdao.getUserbyEmailId(emailId);
		String msg = "";
		if (user_lst.size() == 1) {
			msg = userdao.deleteUser(emailId);
		} else {
			msg = "Account not found for the email-id";
		}
		return msg;

	}

	public List<User> getAllUsers() {

		return userdao.getAllUsers();
	}

	public List<User> getUserbyEmailId(String emailId) {
		List<User> user = userdao.getUserbyEmailId(emailId);
		return user;
	}

	

}
