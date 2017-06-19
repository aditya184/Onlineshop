package com.aditya.SportsMarketBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.SportsMarketBackend.dao.CategoryDAO;
import com.aditya.SportsMarketBackend.dao.ProductDAO;
import com.aditya.SportsMarketBackend.dto.Category;
import com.aditya.SportsMarketBackend.dto.Product;

public class ProductTestCase 
{
	 
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
	    context=new AnnotationConfigApplicationContext();
		context.scan("com.aditya.SportsMarketBackend");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct()
	{
		product=new Product();
		  product.setName("SG Rubber Cricket Shoes");
		  product.setBrand("SG");
		  product.setDescription("This is some Description of SG Cricket Shoe");
		  product.setUnitPrice(3600);
		  product.setActive(true);
		  product.setCategoryId(1);
		  product.setSupplierid(3);
		  
		
			assertEquals("Something went Wrong while inserting a new product",true,productDAO.add(product));

				//fetching or update category
				product=productDAO.get(2);
				product.setName("SG Cricket Gloves");
				assertEquals("Something went Wrong while updating existing record",true,productDAO.update(product));
				
				//delete category
				assertEquals("Something went Wrong while deleting existing record",true,productDAO.delete(product));
	            
				//list of active category
				assertEquals("Something went Wrong while fetching the list of products",8,productDAO.list().size());
				
	}*/

	@Test
	public void testListActiveProducts()
	{
		assertEquals("Something went Wrong while fetching the list of products",7,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory()
	{
		assertEquals("Something went Wrong while fetching the list of products",3,productDAO.listActiveProductsByCategory(1).size());
		assertEquals("Something went Wrong while fetching the list of products",2,productDAO.listActiveProductsByCategory(2).size());
		assertEquals("Something went Wrong while fetching the list of products",2,productDAO.listActiveProductsByCategory(3).size());
	}
	@Test
	public void testGetLatestActiveProducts()
	{
		assertEquals("Something went Wrong while fetching the list of products",4,productDAO.getLatestActiveProducts(4).size());
		
	}
	
}
