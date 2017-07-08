package com.aditya.SportsMarketBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.SportsMarketBackend.dao.UserDAO;
import com.aditya.SportsMarketBackend.dto.Address;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean addUser(User user) {
     try{
			
			sessionfactory.getCurrentSession().persist(user);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean addAddress(Address address) {
		 try{
				
				sessionfactory.getCurrentSession().persist(address);
				return  true;
			  }
			catch(Exception ex)
			{
				return false;
			}
		
		}

	@Override
	public boolean updateCart(Cart cart) {
		try{
			
			sessionfactory.getCurrentSession().update(cart);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
	
		String selectQuery="FROM User WHERE email=:email";
	    try
	    {
	    	return sessionfactory.getCurrentSession().createQuery(selectQuery,User.class).setParameter("email",email).getSingleResult();
	    }
	    catch(Exception ex)
	    {
	    	//ex.printStackTrace();
	    	return null;
	    }
	}

	@Override
	public Address getBillingAddress(User user) {
	    String selectQuery="FROM Address WHERE user = :user AND billing = :billing";
	    
		try{
			return sessionfactory.getCurrentSession().createQuery(selectQuery,Address.class)
					.setParameter("user", user).setParameter("billing", true).getSingleResult();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(User user) {
      String selectQuery="FROM Address WHERE user = :user AND shipping = :shipping";
	    
		try{
			return sessionfactory.getCurrentSession().createQuery(selectQuery,Address.class)
					.setParameter("user", user).setParameter("shipping", true).getResultList();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public User getById(int userId) {
		String selectQuery = "FROM User WHERE id = :userId";

		try {
			return sessionfactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("userId",userId)
					.getSingleResult();
		} catch (Exception ex) {
			 ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Cart getCartById(int cartId) {
		String selectQuery = "FROM Cart WHERE id = :cartId";

		try {
			return sessionfactory.getCurrentSession().createQuery(selectQuery, Cart.class).setParameter("cartId",cartId)
					.getSingleResult();
		} catch (Exception ex) {
			 ex.printStackTrace();
			return null;
		}
	}

}
