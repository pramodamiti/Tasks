package com.rentalSystem.CarRental;
               
public class Car {
    private String model;
    private String engineType;
    private boolean rented;

    public Car(String model, String engineType) {   
        this.model = model;
        this.setEngineType(engineType);
    }

    public void setRented(boolean rented) {       
        this.rented = rented;
    }

    public void init() {
        System.out.println("Car " + model + " is ready to rent!");
    }

    public void cleanup() {
        System.out.println("Destroying Car " + model + "...");
    }

    public void rent() {
        this.rented = true;
        System.out.println("Car " + model + " is now rented: " + rented);
    }

    public String getModel() {
        return model;
    }

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
}
