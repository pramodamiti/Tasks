package com.shoppingcart.ShoppingCart;

public class Customer {
	private String name;
	private Cart cart;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public void buyIteam() {
		System.out.println("Customer: "+name);
		cart.checkout();
	}
	
	

}
