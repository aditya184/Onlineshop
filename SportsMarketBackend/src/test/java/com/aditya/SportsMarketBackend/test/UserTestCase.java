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
    
    /*@Test
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
        address.setAddressLineOne("145 Ganesh Apartment");
        address.setAddressLineTwo(" opp. GHB complex");
        address.setCity("Kalyan");
        address.setState("Maharastra");
        address.setCountry("India");
        address.setPostalCode("420156");
        address.setBilling(true);
    
        address.setUserId(user.getId());
    
        assertEquals("Failed to add Address!",true,userDAO.addAddress(address));
        
        if(user.getRole().equals("USER")){
        	
        	cart=new Cart();
        	cart.setUser(user);
        	
        	assertEquals("Failed to add Cart!",true,userDAO.addCart(cart));
            
        	address=new Address();
            address.setAddressLineOne("145 Ganesh Apartment");
            address.setAddressLineTwo(" opp. GHB complex");
            address.setCity("Kalyan");
            address.setState("Maharastra");
            address.setCountry("India");
            address.setPostalCode("420156");
            address.setShipping(true);
        
            
            address.setUserId(user.getId());
            
            assertEquals("Failed to add Address!",true,userDAO.addAddress(address));
        }   
    } */

    
   /*@Test
    public void testAdd()
    {
    	user=new User();
    	user.setFirstName("Milind");
    	user.setLastName("Patel");
    	user.setEmail("milindp@gmail.com");
    	user.setContactNumber("5242538756");
        user.setRole("USER");
        user.setPassword("123456");
        
           
         if(user.getRole().equals("USER")){
        	
        	 //create cart for this user
        	cart=new Cart();
        
        	cart.setUser(user);
        	
        	user.setCart(cart);
        }
         
       //add the user
         assertEquals("Failed to add user!",true,userDAO.addUser(user));
    }*/
    
    /*@Test
    public void testUpdateCart()
    {
    	user=userDAO.getByEmail("milindp@gmail.com");
    	
    	cart=user.getCart();
    	
        cart.setGrandTotal(5555);
    
        cart.setCartLines(2);
        
        assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
    }*/
    
    /*@Test
    public void testAddAddress()
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
        address.setAddressLineOne("145 Ganesh Apartment");
        address.setAddressLineTwo(" opp. GHB complex");
        address.setCity("Kalyan");
        address.setState("Maharastra");
        address.setCountry("India");
        address.setPostalCode("420156");
        address.setBilling(true);
    	
        //attached the user to the address
        address.setUser(user);
               
        assertEquals("Failed to add address!",true,userDAO.addAddress(address));
        
        //shipping Address
        address=new Address();
        address.setAddressLineOne("145 Ganesh Apartment");
        address.setAddressLineTwo(" opp. GHB complex");
        address.setCity("Kalyan");
        address.setState("Maharastra");
        address.setCountry("India");
        address.setPostalCode("420156");
        address.setShipping(true);
        
        address.setUser(user);
        
        assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
        
    }*/
    
    
    /*@Test
    public void testAddAddress()
    {
        
    	user= userDAO.getByEmail("milindp@gmail.com");
    	
    	//shipping Address
        address=new Address();
        address.setAddressLineOne("145 Ganesh Apartment");
        address.setAddressLineTwo(" opp. GHB complex");
        address.setCity("Thane");
        address.setState("Maharastra");
        address.setCountry("India");
        address.setPostalCode("420156");
        address.setShipping(true);
        
        address.setUser(user);
        
        assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
        
    }*/
    
    /*@Test
    public void testGetAddress()
    {
    	
    	user=userDAO.getByEmail("milindp@gmail.com");
    	
    	assertEquals("Failed to fetch the list of address and size does not match!",2,
    			userDAO.listShippingAddresses(user).size());
    	
    	assertEquals("Failed to fetch the list of address and size does not match!","Kalyan",
    			userDAO.getBillingAddress(user).getCity());
    	
    }*/
    
}
