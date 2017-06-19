package com.aditya.SportsMarketBackend.daoimpl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.SportsMarketBackend.dao.CategoryDAO;
import com.aditya.SportsMarketBackend.dto.Category;

@Repository("categoryDAO")
@Transactional		
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	
	private SessionFactory sessionfactory;
	
	/*private static List<Category> categories= new ArrayList<>();
	
	static
	{
		Category category= new Category();
		category.setId(1);
		category.setName("Cricket");
		category.setDesc("This is some Description of Cricket");
		category.setImageUrl("Cricket.jpg");
		categories.add(category);
		
		category= new Category();
		category.setId(2);
		category.setName("Football");
		category.setDesc("This is some Description of Football");
		category.setImageUrl("football.jpg");
		categories.add(category);
		
		category= new Category();
		category.setId(3);
		category.setName("Tennis");
		category.setDesc("This is some Description of Tennis");
		category.setImageUrl("Tennis.jpg");
		categories.add(category);
		
	}*/
	
	@Override
	public List<Category> list() {
	
		String selectActiveCategory="FROM Category WHERE active=:active";
		Query query=sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);		
		return query.getResultList();
		//return categories;
	}

	@Override

	public boolean add(Category category) {
		try{
			
			sessionfactory.getCurrentSession().persist(category);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Category get(int id) {
		/*for(Category category:categories)
		{
			if(category.getId()==id) return category;
		}
		
		return null;*/
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Category category) {
          try{
			
			sessionfactory.getCurrentSession().update(category);
			return  true;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		  
		category.setActive(false);
		try{
				
				sessionfactory.getCurrentSession().update(category);
				return  true;
			  }
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
	}
}
