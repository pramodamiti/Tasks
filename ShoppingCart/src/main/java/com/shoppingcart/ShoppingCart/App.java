package com.shoppingcart.ShoppingCart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	
    	Customer customer=(Customer) context.getBean("john");
    	
    	Customer customer1=(Customer) context.getBean("pramod");
    	
    	customer.buyIteam();
    	customer1.buyIteam();
    	
    	((AbstractApplicationContext) context).close();
    	
    }
}
