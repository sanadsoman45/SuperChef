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

import com.recipe.superchef.entities.IngCart;

@Repository
public class cartDao {

	@Autowired
	SessionFactory sf;

	public String insertIng(IngCart ingcart) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		String msg = "Ingredient is already added";
		Criteria cr = session.createCriteria(IngCart.class);
		int count = cr.add(Restrictions.and(Restrictions.eq("emailId", ingcart.getEmailId()),
				Restrictions.eq("ingName", ingcart.getIngName()))).list().size();
		Transaction tr = session.beginTransaction();
		if (count == 0) {
			session.save(ingcart);
			msg = "Ingredient " + ingcart.getIngName() + " has been added to cart";
		}
		tr.commit();
		return msg;
	}

	public List<IngCart> getallIng(String emailId) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(IngCart.class);
		return cr.add(Restrictions.eq("emailId", emailId)).list();
	}

	public Object getIngCount(String emailId) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(IngCart.class);
		return cr.add(Restrictions.eq("emailId", emailId)).setProjection(Projections.count("emailId")).list();
	}

	public String deleteAllIng(String emailId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from IngCart where emailid = :emailId");
		query.setParameter("emailId", emailId);
		query.executeUpdate();
		tr.commit();
		return "Cart Cleared for "+emailId;
	}

	public String deleteIng(IngCart ingcart) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("Delete from IngCart where emailid = :emailId and ingName = :ingName and ingType = :ingType");
		query.setParameter("emailId",ingcart.getEmailId());
		query.setParameter("ingName", ingcart.getIngName());
		query.setParameter("ingType", ingcart.getIngtype());
		query.executeUpdate();
		tr.commit();
		return "Item "+ingcart.getIngName()+" has been deleted successfully from the cart.";
	}

	public boolean checkIngByName(IngCart incart) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(IngCart.class);
		List<IngCart> lst = cr.add(Restrictions.and(Restrictions.eq("ingName", incart.getIngName()),Restrictions.eq("emailId", incart.getEmailId()))).list();
		boolean isAdded = false;
		if(lst.size() == 1) {
			isAdded = true;
		}
		
		return isAdded;
	}

}
