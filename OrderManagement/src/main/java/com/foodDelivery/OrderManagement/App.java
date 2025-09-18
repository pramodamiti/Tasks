package com.foodDelivery.OrderManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.foodDelivery.OrderManagement.service.OrderService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Restaurant resto = context.getBean("resto1", Restaurant.class);

		Order order = context.getBean("order", Order.class);

		Customer customer = context.getBean("customer", Customer.class);

		System.out.println("Enter Cutomer id");

		int id = sc.nextInt();
		sc.nextLine(); // 🔥 add this line

		customer.setId(id);

		System.out.println("Enter Cutomer name");
		String name = sc.nextLine();
		customer.setName(name);

		System.out.println("Enter Cutomer phone");
		String phone = sc.nextLine();
		customer.setPhone(phone);

		System.out.println("Enter Cutomer adress");
		String adress = sc.nextLine();
		customer.setAdress(adress);

		System.out.println("Menu:");
		for (FoodIteam item : resto.getFood()) {
			System.out.println(item.getFoodId() + ". " + item.getFoodname() + " - Rs." + item.getPrice());
		}
		System.out.println("Enter food item ids separated by comma (e.g., 1,3):");
		String[] selectedIds = sc.nextLine().split(",");

		List<FoodIteam> selectedFood = new ArrayList<>();

		for (String id1 : selectedIds) {
			int foodId = Integer.parseInt(id1.trim());
			for (FoodIteam item : resto.getFood()) {
				if (item.getFoodId() == foodId) {
					selectedFood.add(item);
				}
			}
		}
		if (selectedFood.size() == 0) {
			System.out.println("no food iteam is selected");
			main(selectedIds);
		}

// set data in order
		order.setCustomer(customer);
		order.setFood(selectedFood);

		OrderService os = (OrderService) context.getBean("orderService");
		os.placeOrder(order);

		((AbstractApplicationContext) context).close();
		sc.close();
	}
}
