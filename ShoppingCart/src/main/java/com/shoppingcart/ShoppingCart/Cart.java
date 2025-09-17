package com.shoppingcart.ShoppingCart;

import java.util.List;

public class Cart {
	private List<Product> products;
	
	
	
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Cart(List<Product> products) {
		this.products = products;
	}

	public void checkout() {
		int cost=0;
		for(Product product:products) {
			cost+=product.getPrice();
		}
		System.out.println("Total: "+"$"+cost);
	}
	
	public void init() {
		System.out.println("Cart is Ready!");
	}
	
	public void destroy() {
		System.out.println("Cart is Destroyed!");
	}
}
