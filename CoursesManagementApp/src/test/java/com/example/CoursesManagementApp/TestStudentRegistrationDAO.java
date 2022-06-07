package com.example.CoursesManagementApp;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.CoursesManagementApp.dao.StudentRegistrationDAO;
import com.example.CoursesManagementApp.entity.StudentRegistration;

@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application.properties")
public class TestStudentRegistrationDAO {

	@Autowired
	StudentRegistrationDAO studentRegistrationDAO;
	
	@Test
	void testStudentRegistrationDAOIsNotNull() {
		Assertions.assertNotNull(studentRegistrationDAO);
	}
	
	//Test only the methods i have implement
	//and not methods which use entity manager methods (persist, merge ...)
	@Test
	void testFindRegistrationsByCourseId() {
		List<StudentRegistration> students = studentRegistrationDAO.findRegistrationsByCourseId(1);
		Assertions.assertNotNull(students);
		Assertions.assertEquals("Spiros", students.get(0).getName());
	}
}
