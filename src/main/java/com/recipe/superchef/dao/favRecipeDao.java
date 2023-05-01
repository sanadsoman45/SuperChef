package com.recipe.superchef.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.superchef.entities.FavRecipes;

@Repository
public class favRecipeDao {

	@Autowired
	SessionFactory sf;
	
	public String addRecipe(FavRecipes favrecipe) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria cr = session.createCriteria(FavRecipes.class);
		int count = cr.add(Restrictions.and(Restrictions.eq("emailId", favrecipe.getEmailId()),Restrictions.eq("favrecipeName", favrecipe.getFavrecipeName()))).list().size();
		String msg = "Records Insertion Failed";
		if(count == 0) {
			session.save(favrecipe);
			msg = "Recipe "+favrecipe.getFavrecipeName()+" has been added successfully.";
		}
		tr.commit();
		return msg;
	}

	public String removeRecipeByName(FavRecipes favrecipes) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from FavRecipes where emailId = :emailId and favrecipeName = :recipeName");
		query.setParameter("emailId", favrecipes.getEmailId());
		query.setParameter("recipeName", favrecipes.getFavrecipeName());
		query.executeUpdate();
		tr.commit();
		return "Records deletion successful";
	}

	public List getCountRecipes(String emailId) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(FavRecipes.class);
		return cr.add(Restrictions.eq("emailId", emailId)).setProjection(Projections.count("favrecipeName")).list();
		
	}

	public List<FavRecipes> getAllFavRecipes(String emailId) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(FavRecipes.class);
		return cr.add(Restrictions.eq("emailId", emailId)).list();
	}

	public String deleteAllFavRecipes(String emailId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from FavRecipes where emailId = :emailId");
		query.setParameter("emailId", emailId);
		query.executeUpdate();
		tr.commit();
		return "Records Deleted Successfully";
	}

}
