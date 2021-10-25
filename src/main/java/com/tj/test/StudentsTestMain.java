package com.tj.test;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.tj.test.model.Student;
import com.tj.test.service.StudentService;

public class StudentsTestMain {
	
	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		List<Student> students  = studentService.getStudents();
		
		Comparator<Student> studentByCourse = Comparator.comparing(Student::getCourse);
		
		/*
		 * DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("MM/dd/yyyy '@'hh:mm a");
		 * Collections.sort(datestring, (s1, s2) -> LocalDateTime.parse(s1, formatter).
		 * compareTo(LocalDateTime.parse(s2, formatter))); Comparator<Student>
		 * studentByExamDate = (s1, s2) ->
		 * formatter.parse(s1).compareTo(formatter.parse(s2));
		 */
        Comparator<Student> studentByExamDate = Comparator.comparing(Student::getExamDate);
        Comparator<Student> studentBySurname = Comparator.comparing(Student::getSurname);
		
		 Comparator<Student> combinedCompare = studentByCourse.thenComparing(studentByExamDate).thenComparing(studentBySurname);
		 
	   List<Student> sortedStudents = students.stream().sorted(combinedCompare).collect(Collectors.toList());

		
	}

}
