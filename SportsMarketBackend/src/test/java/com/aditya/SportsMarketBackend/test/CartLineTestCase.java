package com.aditya.SportsMarketBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.SportsMarketBackend.dao.CartLineDAO;
import com.aditya.SportsMarketBackend.dao.ProductDAO;
import com.aditya.SportsMarketBackend.dao.UserDAO;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.CartLine;
import com.aditya.SportsMarketBackend.dto.Product;
import com.aditya.SportsMarketBackend.dto.User;

public class CartLineTestCase {

private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;
	
	Product product=null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.aditya.SportsMarketBackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	

	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("milindp@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(3);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setProductCount(1);
		
		double oldTotal = cartLine.getTotal();		
		
		cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		assertEquals("Failed to update the cart!",true, userDAO.updateCart(cart));
		
	}
	
	/*@Test
	public void testUpdateCartlines() {
		String email = "milindp@gmail.com";
		CartLine cartline = new CartLine();
		User user = (User) userDAO.getByEmail(email);
		product = (Product) productDAO.get(3);
		cartline = (CartLine) cartLineDAO.ifExists(user.getCart().getId(),product.getId());
		//cartline.setProdId(product.getId());
		//cartline.setCartId(user.getCart().getId());
		cartline.setBuyingPrice(product.getUnitPrice());
		cartline.setProductCount((cartline.getProductCount())+ 1);
		
		cartline.setTotal(cartline.getProductCount() * cartline.getBuyingPrice());
		cartline.setAvailable(product.isActive());
		assertEquals("Something went wrong while updating cartline", true, cartLineDAO.update(cartline));
	}*/
	
	/*@Test
	public void testDeleteCartlines() {
		String email = "milindp@gmail.com";
		CartLine cartline = new CartLine();
		User user = (User) userDAO.getByEmail(email);
		product = (Product) productDAO.get(3);
		cartline = (CartLine) cartLineDAO.ifExists(user.getCart().getId(),product.getId());	
	assertEquals("Something went wrong while deleting cart line",true,cartLineDAO.remove(cartline));
	}*/
	

}
