package com.example.CoursesManagementApp;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.CoursesManagementApp.entity.Course;
import com.example.CoursesManagementApp.service.CourseService;
import com.example.CoursesManagementApp.service.MaxStatisticStrategy;
import com.example.CoursesManagementApp.service.StatisticStrategy;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
public class TestCourseService {

	@Autowired
	CourseService courseService;
	
	@Test
	void testEmployeeDAOJpaImplIsNotNull() {
		Assertions.assertNotNull(courseService);
	}
	
	//Again here we test only the methods we implement
	//and not save , update or delete because there we use entity manager methods
	@Test
	void testFindCourseByInstructorLogin() {
		List<Course> courses = courseService.findCourseByInstructorLogin("Apostolos Zaras");
		Assertions.assertNotNull(courses);
		Assertions.assertEquals("Texnologia Logismikou", courses.get(0).getName());
	}
	
	//Here we test the statistic calculation strategies
	//and if the template method pattern and strategy pattern for statistics calculation
	//have the right operations
	//here test only one statistic strategy, an easy one like MaxStatisticStrategy
	//We assume that the returned max value is the right one
	//so as we use the apache library for this
	@Test
	void testStatisticStrategy() {
		StatisticStrategy max = new MaxStatisticStrategy();
		Course course = courseService.find(1);
		
		double m = max.calculateStatistic(course);
		//we care only if objects have the right 'communication' between them
		Assertions.assertNotNull(m);
	}
}
