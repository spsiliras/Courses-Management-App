package com.example.CoursesManagementApp;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.CoursesManagementApp.entity.StudentRegistration;
import com.example.CoursesManagementApp.service.StudentRegistrationService;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class TestStudentRegistrationService {

	@Autowired
	StudentRegistrationService studentRegistrationService;
	
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(studentRegistrationService);
	}
	
	//Again here we test only the method we implement
	//and not save , update or delete because there we use entity manager methods
	@Test
	void testFindRegistrationsByCourseId() {
		List<StudentRegistration> students = studentRegistrationService.findRegistrationsByCourseId(1);
		Assertions.assertNotNull(students);
		Assertions.assertEquals("Spiros", students.get(0).getName());
	}
	
}
