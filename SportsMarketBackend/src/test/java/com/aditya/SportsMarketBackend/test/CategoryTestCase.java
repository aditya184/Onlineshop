package com.aditya.SportsMarketBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.SportsMarketBackend.dao.CategoryDAO;
import com.aditya.SportsMarketBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
	    context=new AnnotationConfigApplicationContext();
		context.scan("com.aditya.SportsMarketBackend");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
    public void testAddCategory()
	{
	
	  category=new Category();
	  category.setName("Football");
	  category.setDesc("This is some Description of Football");
	  category.setImageUrl("Football.jpg");
	
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.get(3);
		assertEquals("Successfully fetched a single category from the table","Football",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(3);
		category.setName("Hockey");
		assertEquals("Successfully updated a single category in the table",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(3);
		assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory(){
		assertEquals("Successfully Fetched list of categories from the table",2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory()
	{
		category=new Category();
		  category.setName("Cricket");
		  category.setDesc("This is some Description of Cricket");
		  category.setImageUrl("Cricket.jpg");
		
			assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));

			category=new Category();
			  category.setName("Football");
			  category.setDesc("This is some Description of Football");
			  category.setImageUrl("Football.jpg");
			
				assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
                
				//fetching or update category
				category=categoryDAO.get(2);
				category.setName("football");
				assertEquals("Successfully updated a single category in the table",true,categoryDAO.update(category));
				
				//delete category
				assertEquals("Successfully deleted a single category in the table",true,categoryDAO.delete(category));
	            
				//list of active category
				assertEquals("Successfully Fetched list of categories from the table",1,categoryDAO.list().size());
				
	}
	
}
