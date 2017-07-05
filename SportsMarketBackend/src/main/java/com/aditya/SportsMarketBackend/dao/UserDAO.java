package com.aditya.SportsMarketBackend.dao;

import java.util.List;

import com.aditya.SportsMarketBackend.dto.Address;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	boolean updateCart(Cart cart);
	
}
