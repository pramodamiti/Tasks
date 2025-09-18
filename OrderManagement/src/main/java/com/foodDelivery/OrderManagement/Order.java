package com.foodDelivery.OrderManagement;

import java.util.List;

//orderId, Customer, Restaurant, List<FoodItem>, DeliveryAgent, totalPrice
public class Order {
	private int orderId;
	private Customer customer;
	private Restaurant restorant;
	private List<FoodIteam> food;
	private DeliveryAgent deliveryAgent;
	private int totalPrice;
	
	
	
	
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestorant() {
		return restorant;
	}

	public void setRestorant(Restaurant restorant) {
		this.restorant = restorant;
	}

	public List<FoodIteam> getFood() {
		return food;
	}

	public void setFood(List<FoodIteam> food) {
		this.food = food;
	}

	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void init() {
		System.out.println();
	}
	
	public void cleanup() {
		System.out.println();
	}
	
	
}
