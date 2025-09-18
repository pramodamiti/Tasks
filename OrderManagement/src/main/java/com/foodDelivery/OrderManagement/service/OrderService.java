package com.foodDelivery.OrderManagement.service;

import com.foodDelivery.OrderManagement.FoodIteam;
import com.foodDelivery.OrderManagement.Order;

public class OrderService {
	

	
	public void placeOrder(Order order) {
		        // calculate price
		        int total = order.getFood()
		                         .stream()
		                         .mapToInt(FoodIteam::getPrice)
		                         .sum();
		        order.setTotalPrice(total);

		        // print summary
		        System.out.println("----- Order Summary -----");
		        System.out.println("Order ID: " + order.getOrderId());
		        System.out.println("Customer: " + order.getCustomer().getName());
		        System.out.println("Restaurant: " + order.getRestorant().getRestoname());
		        System.out.println("Food Items:");
		        order.getFood().forEach(f -> 
		            System.out.println(" - " + f.getFoodname() + " : " + f.getPrice())
		        );
		        System.out.println("Delivery Agent: " + order.getDeliveryAgent().getAgentName());
		        System.out.println("Total Price: " + order.getTotalPrice());
		    }
		}

