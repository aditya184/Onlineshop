package com.aditya.SportsMarketBackend.dao;

import com.aditya.SportsMarketBackend.dto.Address;
import com.aditya.SportsMarketBackend.dto.Cart;
import com.aditya.SportsMarketBackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean addUser(Cart cart);
	
}
