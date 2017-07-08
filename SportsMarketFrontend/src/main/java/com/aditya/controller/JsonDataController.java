package com.aditya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aditya.SportsMarketBackend.dao.CartLineDAO;
import com.aditya.SportsMarketBackend.dao.ProductDAO;
import com.aditya.SportsMarketBackend.dto.CartLine;
import com.aditya.SportsMarketBackend.dto.Product;



@Controller
@RequestMapping("/json/data")
public class JsonDataController
{

	@Autowired
	private ProductDAO productDAO;
    
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
  	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		
		return productDAO.list();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		
		return productDAO.listActiveProductsByCategory(id);
	}
	

	@RequestMapping("/cart/{id}/items")
	@ResponseBody
	public List<CartLine> getCartItem(@PathVariable int id){
		
		//List<CartItems> caritems =new <CartItems>; 
		
		return cartLineDAO.list(id);
	}
	
}
