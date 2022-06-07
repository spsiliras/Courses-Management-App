package com.example.CoursesManagementApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CoursesManagementApp.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public CourseDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public CourseDAOImpl() {
		
	}
	
	@Override
	@Transactional
	public List<Course> findCourseByInstructorLogin(String instructor){
		String jpql = "SELECT c FROM Course c WHERE c.instructor LIKE :instrName";
		TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
		query.setParameter("instrName", instructor);
		
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Course find(int course_id) {
		Course course = entityManager.find(Course.class, course_id);
		return course;
	}
	
	@Override
	@Transactional
	public void delete(int course_id) {
		Course course = entityManager.find(Course.class, course_id);
		entityManager.remove(course);
	}
	
	@Override
	@Transactional
	public void save(Course course) {
		entityManager.persist(course);
	}
	
	@Override
	@Transactional
	public void update(Course course) {
		
		entityManager.merge(course);
	}
}
