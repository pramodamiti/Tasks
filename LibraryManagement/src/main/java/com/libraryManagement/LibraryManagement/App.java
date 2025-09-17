package com.libraryManagement.LibraryManagement;

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
    	ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
    	Member member=(Member) context.getBean("pramod");
    	member.list();
    	((AbstractApplicationContext) context).close();
    	
    }
}
