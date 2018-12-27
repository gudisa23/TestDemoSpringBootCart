package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.demo.exception.DemoBusinessRuntimeException;
import com.example.demo.model.Cart;
@Service
public class CartServiceImpl implements ICartService {

	private static Map<Long, Cart> cartsRepo = new ConcurrentHashMap<>();
	
	@Override
	public Cart findCart(long id) {
		// TODO Auto-generated method stub
		return cartsRepo.get(id);
	}

	@Override
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		
		if(cart == null) {
			throw new DemoBusinessRuntimeException("Cart details are not provided.");
		}
		if(cart == null) {
			throw new DemoBusinessRuntimeException("Cart details are not provided.");
		}
		
		long cartId = cartsRepo.size() + 1;
		cart.setCartId(cartId);
		cart.setCreatedDate(LocalDateTime.now().toString());
		cartsRepo.put(cartId, cart);
		
	}

	@Override
	public void deleteCart(long id) {
		// TODO Auto-generated method stub
		if (!cartsRepo.containsKey(id)) {
			throw new DemoBusinessRuntimeException("Cart id doesn't exists");
		}
		
		cartsRepo.remove(id);
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		if(cart == null) {
			throw new DemoBusinessRuntimeException("Cart details are not provided.");
		}
		
		if(cart.getCartId() != null) {
			throw new DemoBusinessRuntimeException("Cart id is not allowed.");
		}
		
		if (!cartsRepo.containsKey(cart.getCartId())) {
			throw new DemoBusinessRuntimeException("Cart id doesn't exists");
		}
		
	}

}
