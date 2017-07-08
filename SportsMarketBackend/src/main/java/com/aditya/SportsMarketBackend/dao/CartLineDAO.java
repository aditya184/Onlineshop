package com.aditya.SportsMarketBackend.dao;

import java.util.List;

import com.aditya.SportsMarketBackend.dto.CartLine;

public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);

	CartLine ifExists(int cartId,int productId);

}
