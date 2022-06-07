package com.example.CoursesManagementApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.CoursesManagementApp.controller.CoursesMgtAppController;
import com.example.CoursesManagementApp.entity.Course;

@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class TestCoursesMgtAppController {

	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CoursesMgtAppController coursesMgtAppController;
	
	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testCoursesMgtAppControllerIsNotNull() {
		Assertions.assertNotNull(coursesMgtAppController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	@Test
	void testShowFormForAddCourseReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/showFormForAddCourse")).
		andExpect(status().isOk()).
		andExpect(view().name("courses/course-form"));
	}
	
	@Test
	void testListCoursesReturnsPage() throws Exception {
		mockMvc.perform(get("/courses/list")).
		andExpect(status().isOk()).
		andExpect(view().name("courses/list-courses"));
	}
	
	@Test
	void testSaveCourseReturnsPage() throws Exception {
		Course course = new Course("Texnologia Logismikou", "myy803", "Apostolos Zaras", 3, 6);
		
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		
		multiValueMap.add("course_id", Integer.toString(course.getCourse_id()));
		multiValueMap.add("name", course.getName());
		multiValueMap.add("description", course.getDescription());
		multiValueMap.add("year", Integer.toString(course.getYear()));
		multiValueMap.add("semester", Integer.toString(course.getSemester()));
		
		mockMvc.perform(
				post("/courses/save")
			    .params(multiValueMap))
				.andExpect(status().isFound())
				.andExpect(view().name("redirect:/courses/list"));
	}
}
