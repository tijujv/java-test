package com.tj.test.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tj.test.model.Student;

public class StudentService {
	
	private List<Student> students = new ArrayList<Student>();
	
	public List<Student> getStudents(){
		
		if(students != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				students = objectMapper.readValue(new File("src/main/resources/student_data_export.json"), new TypeReference<List<Student>>(){});
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return students;
	}

}
