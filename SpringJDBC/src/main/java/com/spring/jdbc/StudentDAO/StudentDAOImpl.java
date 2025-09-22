package com.spring.jdbc.StudentDAO;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entity.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		
		String query="insert into student(id,Name,city) values(?,?,?)";
		int update = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		System.out.println("data inserted !!!!");
		return update;
	}

	@Override
	public int delete(int id) {
		String query="delete from student where id=? ";
		int update=this.jdbcTemplate.update(query,id);
		System.out.println("student deleted !!!!!!!!");
		return update;
	}

	@Override
	public void show() {
	    String query = "SELECT * FROM student";
	    List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	    for (Map<String, Object> row : rows) {
	        System.out.println(row);
	    }
	}

	@Override
	public void update(int id,String name,String city) {
		String query="UPDATE student SET name = ?, city = ? WHERE id = ?";
		int result = this.jdbcTemplate.update(query,name,city,id);
		if(result > 0) {
	        System.out.println("Student updated successfully!");
	    }
	}
	

}
