package com.aditya.SportsMarketBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.SportsMarketBackend.dao.ProductDAO;
import com.aditya.SportsMarketBackend.dto.Product;




@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionfactory;


	
	@Override
	public Product get(int productid) {
		try
		{
		return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(productid));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		
		return sessionfactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
		
	}

	@Override
	public boolean add(Product product) {
try{
			
			sessionfactory.getCurrentSession().persist(product);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
	
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
try{
			
			sessionfactory.getCurrentSession().update(product);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
		
		}
      return false;
	}
	

	@Override
	public boolean delete(Product product) {
try{
			
			product.setActive(false);
			return  this.update(product);
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
		
		}
      return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="FROM Product WHERE active=:active";
		return sessionfactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCaegory="FROM Product WHERE active=:active AND categoryId=:categoryId";
		return sessionfactory.getCurrentSession().createQuery(selectActiveProductsByCaegory,Product.class).setParameter("active", true).setParameter("categoryId",categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count)
	{
		return sessionfactory.getCurrentSession().createQuery("FROM Product WHERE active=:active ORDER BY id",Product.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

		
}
