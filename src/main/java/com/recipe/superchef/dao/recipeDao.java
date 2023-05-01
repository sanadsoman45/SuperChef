package com.recipe.superchef.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.superchef.entities.Recipes;

@Repository
public class recipeDao {

	@Autowired
	SessionFactory sf;

	public String insertRecipes(Recipes recipes) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String msg = "";
		Criteria cr = session.createCriteria(Recipes.class);
		int count = cr.add(Restrictions.eq("recipeName", recipes.getRecipeName())).list().size();
		if (count == 0) {
			session.save(recipes);
			msg = recipes.getRecipeName() + " has been inserted successfully with associated details.";
		} else {
			msg = "Recipe " + recipes.getRecipeName() + " had already been added.";
		}
		tr.commit();
		return msg;
	}

	public List getCountRecipes() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Recipes.class);
		List count = cr.setProjection(Projections.rowCount()).list();
		return count;
	}

	public List<Recipes> getAllRecipes() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Recipes.class);
		return cr.list();
	}

	public String deleteRecipe(String recipeName) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("DELETE FROM Recipes where recipeName = :recipeName");
		query.setParameter("recipeName", recipeName);
		query.executeUpdate();
		tr.commit();
		return "Recipe " + recipeName + " deleted sucessfully.";
	}
//
//	public Object getCookTimebetween(String time) {
//		Session session = sf.openSession();
//		
//		return null;
//	}

}
