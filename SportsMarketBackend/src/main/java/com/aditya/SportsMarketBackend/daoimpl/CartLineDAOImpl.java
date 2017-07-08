package com.aditya.SportsMarketBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.SportsMarketBackend.dao.CartLineDAO;
import com.aditya.SportsMarketBackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
    
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionfactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();		
	}

	@Override
	public CartLine get(int id) {		
		return sessionfactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
	}


	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionfactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {	
		try {			
			sessionfactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}

	@Override
	public CartLine ifExists(int cartId, int productId) {
		String selectQuery = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";

		try {
			return sessionfactory.getCurrentSession()
					.createQuery(selectQuery,CartLine.class)
					.setParameter("cartId",cartId)
					.setParameter("productId",productId)
					.getSingleResult();
					
			
		} catch (Exception ex) {
		    ex.printStackTrace();
			return null;
		}
	}

}
