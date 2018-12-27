package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.service.CartServiceImpl;

@Controller
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartServiceImpl cartServiceImpl;

	@RequestMapping("/test")
	public String get() {
		return "Test";
	}

	@RequestMapping("/get/{id}")
	public Cart findCart(@PathVariable("id") String id) {
		Cart cart = cartServiceImpl.findCart(Long.valueOf(id));
		return cart;

	}

	@RequestMapping("/update/{id}")
    public void createCart(@RequestBody Cart cart) {
		cartServiceImpl.saveCart(cart);
	}

    /*@RequestMapping("/update/{id}")
	public void updateCart(@RequestBody Cart cart) {
		cartServiceImpl.updateCart(cart);
	}*/

	@RequestMapping("/delete/{id}")
	public void deleteCart(@PathVariable("id") String id) {
		cartServiceImpl.deleteCart(Long.valueOf(id));
	}

}