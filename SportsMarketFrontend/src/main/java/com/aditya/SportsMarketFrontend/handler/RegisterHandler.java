package com.aditya.SportsMarketFrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.aditya.SportsMarketBackend.dao.UserDAO;
import com.aditya.SportsMarketBackend.dto.Address;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.User;
import com.aditya.SportsMarketFrontend.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO; 
	
	@Autowired
	private	BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	
	public String validateUser(User user, MessageContext error)
	{
		String transitionValue = "success";
		
	    if(!(user.getPassword().equals(user.getConfirmPassword())))
	    {
	    	error.addMessage(new MessageBuilder()
	    			.error()
	    			.source("confirmPassword")
	    			.defaultText("Password does not match the Confirm Password!")
	    			.build());
	    
	    	transitionValue="failure";
	    }
		
		if(userDAO.getByEmail(user.getEmail())!=null)
		{
			error.addMessage(new MessageBuilder()
	    			.error()
	    			.source("email")
	    			.defaultText("Email address is already used!")
	    			.build());
			
			transitionValue="failure";
		}
		return transitionValue;
	}
	
	
	public String saveAll(RegisterModel registerModel){
		String transitionValue = "success";
		
		User user= registerModel.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart=new Cart();
			
			cart.setUser(user);
			
			user.setCart(cart);
		}
		
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		userDAO.addUser(user);
		
		System.out.println(user);
		
		Address billing = registerModel.getBilling();
		
		billing.setUserId(user.getId());
		billing.setBilling(true);
	    
		System.out.println(billing);
		userDAO.addAddress(billing);		
		
		return transitionValue;
 	}
}
