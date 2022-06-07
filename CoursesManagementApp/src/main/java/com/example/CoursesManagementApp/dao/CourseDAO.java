package com.example.CoursesManagementApp.dao;

import java.util.List;

import com.example.CoursesManagementApp.entity.Course;

public interface CourseDAO {
	
	public List<Course> findCourseByInstructorLogin(String name);
	
	public Course find(int course_id);
	
	public void delete(int id);
	
	public void save(Course course);
	
	public void update(Course course);
}
