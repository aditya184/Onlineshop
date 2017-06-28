package com.aditya.SportsMarketBackend.daoimpl;

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
				ex.printStackTrace();
				return false;
			}
		
		}

	@Override
	public boolean addUser(Cart cart) {
		try{
			
			sessionfactory.getCurrentSession().persist(cart);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
