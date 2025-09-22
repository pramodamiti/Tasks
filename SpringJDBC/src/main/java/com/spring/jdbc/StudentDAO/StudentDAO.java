package com.spring.jdbc.StudentDAO;

import com.spring.jdbc.entity.Student;

public interface StudentDAO {
	public int insert(Student Student);
	
	public int delete(int id);
	
	public void show();
	
	public void update(int id,String name,String city);
}
