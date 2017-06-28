package com.aditya.SportsMarketBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aditya.SportsMarketBackend.dao.UserDAO;
import com.aditya.SportsMarketBackend.dto.Address;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
    private User user=null;
    private Cart cart=null;
    private Address address=null;

    @BeforeClass
    public static void init()
    {
    	context=new AnnotationConfigApplicationContext();
    	context.scan("com.aditya.SportsMarketBackend");
    	context.refresh();
    	userDAO=(UserDAO) context.getBean("userDAO");
    	
    }
    
    @Test
    public void testAdd()
    {
    	user=new User();
    	user.setFirstName("Milind");
    	user.setLastName("Patel");
    	user.setEmail("milindp@gmail.com");
    	user.setContactNumber("5242538756");
        user.setRole("USER");
        user.setPassword("123456");
        
        assertEquals("Failed to add user!",true,userDAO.addUser(user));
    
        address=new Address();
        
    
    
    
    
    
    } 


}
