package com.example.CoursesManagementApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CoursesManagementApp.entity.Course;
import com.example.CoursesManagementApp.entity.StudentRegistration;

@Repository
public class StudentRegistrationDAOImpl implements StudentRegistrationDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public StudentRegistrationDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public StudentRegistrationDAOImpl() {
		
	}
	
	@Override
	@Transactional
	public List<StudentRegistration> findRegistrationsByCourseId(int course_id){
		Course course = entityManager.find(Course.class, course_id);
		return course.getStudents();
	}
	
	@Override
	@Transactional
	public StudentRegistration find(int student_id) {
		StudentRegistration student = entityManager.find(StudentRegistration.class, student_id);
		return student;
	}
	@Override
	@Transactional
	public void delete(int student_id) {
		StudentRegistration student = entityManager.find(StudentRegistration.class, student_id);
		entityManager.remove(student);
	}
	
	@Override
	@Transactional
	public void save(StudentRegistration student, int course_id) {
		Course course = entityManager.find(Course.class, course_id);
		course.getStudents().add(student);
	}
	
	@Override
	@Transactional
	public void update(StudentRegistration student) {
		entityManager.merge(student);
	}
}
