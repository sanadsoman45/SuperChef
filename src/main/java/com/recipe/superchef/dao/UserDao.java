package com.recipe.superchef.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.superchef.entities.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sf;

	public String createUser(User user) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		return "User Details Inserted Successfully";
	}

	public String updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(user);
		tr.commit();
		return "Records Updated Successfully for" + user.getName();
	}

	public List<User> getUserbyEmailId(String emailid) {

		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		return cr.add(Restrictions.eq("email", emailid)).list();

	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		return cr.list();
	}

	public String deleteUser(String emailId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from User where email = :emailId");
		query.setParameter("emailId", emailId);
		query.executeUpdate();
		tr.commit();
		return "Records Deleted";
	}

	
	

}
