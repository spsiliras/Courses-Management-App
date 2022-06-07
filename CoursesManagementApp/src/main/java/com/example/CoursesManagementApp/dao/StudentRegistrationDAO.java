package com.example.CoursesManagementApp.dao;

import java.util.List;

import com.example.CoursesManagementApp.entity.StudentRegistration;

public interface StudentRegistrationDAO {

	public List<StudentRegistration> findRegistrationsByCourseId(int course_id);
	
	public StudentRegistration find(int student_id);
	
	public void delete(int student_id);
	
	public void save(StudentRegistration student, int course_id);
	
	public void update(StudentRegistration student);
}
