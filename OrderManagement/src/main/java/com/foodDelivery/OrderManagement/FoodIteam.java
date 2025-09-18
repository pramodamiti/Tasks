package com.foodDelivery.OrderManagement;

public class FoodIteam {
	private int foodId;
	private String foodname;
	private int price;
	
	
	public FoodIteam(int foodId, String foodname, int price) {
		super();
		this.foodId = foodId;
		this.foodname = foodname;
		this.price = price;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getFoodname() {
		return foodname;
	}


	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
