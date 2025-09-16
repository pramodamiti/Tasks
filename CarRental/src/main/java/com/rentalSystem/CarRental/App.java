package com.rentalSystem.CarRental;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	 
//    	 Car bmw= (Car) context.getBean("bmw");

         Customer john = (Customer) context.getBean("john");
         Customer jane = (Customer) context.getBean("jane");

         john.rentCar();
         jane.rentCar();

         ((ClassPathXmlApplicationContext) context).close();
    }
}
