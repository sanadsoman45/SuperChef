package com.recipe.superchef.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.recipe.superchef.entities.Ingredients;

@Repository
public class IngredientDao {

	@Autowired
	SessionFactory sf;

	public List<Ingredients> getAllIng(String emailId) {

		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Ingredients.class);
		return cr.add(Restrictions.eq("emailId", emailId)).list();
	}

	public String insertIng(Ingredients ing) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String msg = "Ingredient already added";
		Criteria cr = session.createCriteria(Ingredients.class);
		int count = cr.add(Restrictions.and(Restrictions.eq("emailId", ing.getEmailId()),
				Restrictions.eq("ingName", ing.getIngName()))).list().size();
		if (count == 0) {
			session.save(ing);
			tr.commit();
			msg = "Ingredient " + ing.getIngName() + " of Category " + ing.getCategory()
			+ " has been inserted successfully.";
		}

		return msg;
	}

	public String deleteIng(Ingredients ing) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from Ingredients where ing_name = :ingName and emailId = :emailId");
		query.setParameter("ingName", ing.getIngName());
		query.setParameter("emailId", ing.getEmailId());
		query.executeUpdate();
		tr.commit();
		return "Ingredient " + ing.getIngName() + " has been removed from the cart.";
	}

	public Object getIngCount(String emailId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Ingredients.class);
		List rows = cr.add(Restrictions.eq("emailId", emailId)).setProjection(Projections.count("ingName")).list();
		return rows;
	}

	public String deleteAll(String emailId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from Ingredients where emailId = :emailId");
		query.setParameter("emailId", emailId);
		int count = query.executeUpdate();
		tr.commit();
		return "Records Deleted Successfully.";
	}

}
