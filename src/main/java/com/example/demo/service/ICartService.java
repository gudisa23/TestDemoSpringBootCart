package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;


public interface ICartService {
	Cart findCart(long id);

	void saveCart(Cart cart);

	void deleteCart(long id);

	void updateCart(Cart cart);
}
