package com.spring.jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.StudentDAO.StudentDAO;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
		Student student = new Student();
		System.out.println("enter student Id  : ");
		int id = sc.nextInt();
		student.setId(id);
		sc.nextLine();

		System.out.println("enter student Name : ");
		String name = sc.nextLine();
		student.setName(name);

		System.out.println("enter student city : ");
		String city = sc.nextLine();
		student.setCity(city);

		student.getId();
		student.getName();
		student.getCity();

		studentDAO.insert(student);

		System.out.println("enter the student id to delete : ");

		int id1 = sc.nextInt();
		studentDAO.delete(id1);
		studentDAO.show();
		studentDAO.update(id, name, city);

	}
}
