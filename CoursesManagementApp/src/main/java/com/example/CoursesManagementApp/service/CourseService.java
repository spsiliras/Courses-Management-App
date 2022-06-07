package com.example.CoursesManagementApp.service;

import java.util.HashMap;
import java.util.List;

import com.example.CoursesManagementApp.entity.Course;

public interface CourseService {

	public List<Course> findCourseByInstructorLogin(String instructor);
	
	public HashMap<String, Double> getCourseStatistics(Course course);
	
	public Course find(int course_id);
	
	public void delete(int course_id);
	
	public void save(Course course);
	
	public void update(Course course);
}
