package com.example.CoursesManagementApp;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.CoursesManagementApp.dao.CourseDAO;
import com.example.CoursesManagementApp.entity.Course;

@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application.properties")
public class TestCourseDAO {

	@Autowired
	CourseDAO courseDAO;
	
	@Test
	void testCourseDAOIsNotNull() {
		Assertions.assertNotNull(courseDAO);
	}
	
	//Test only the methods i have implement
	//and not methods which use entity manager methods (persist, merge ...)
	@Test
	void testFindCourseByInstructorLogin() {
		List<Course> courses = courseDAO.findCourseByInstructorLogin("Apostolos Zaras");
		Assertions.assertNotNull(courses);
		Assertions.assertEquals("Texnologia Logismikou", courses.get(0).getName());
	}
}
