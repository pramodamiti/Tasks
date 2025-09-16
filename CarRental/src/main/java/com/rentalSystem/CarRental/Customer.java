package com.rentalSystem.CarRental;


public class Customer {
    private String name;
    private Car car; 

    public Customer(String name, Car car) {  
        this.name = name;
        this.car = car;
    }

    public void rentCar() {
        System.out.println("Customer " + name + " rents car " + car.getModel() + ".");
        car.rent();
    }

    public void init() {
        System.out.println("Customer " + name + " is ready!");
    }

    public void cleanup() {
        System.out.println("Destroying Customer " + name + "...");
    }
}
