package com.foodDelivery.OrderManagement;

import java.util.List;

public class Restaurant {
	private int restoId;
	private String restoname;
	private List<FoodIteam> food;
	
	
	
	public Restaurant(int restoId, String restoname, List<FoodIteam> food) {
		this.restoId = restoId;
		this.restoname = restoname;
		this.food = food;
	}



	public int getRestoId() {
		return restoId;
	}



	public void setRestoId(int restoId) {
		this.restoId = restoId;
	}



	public String getRestoname() {
		return restoname;
	}



	public void setRestoname(String restoname) {
		this.restoname = restoname;
	}



	public List<FoodIteam> getFood() {
		return food;
	}



	public void setFood(List<FoodIteam> food) {
		this.food = food;
	}

	
	
	
	

}
