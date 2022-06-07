package com.example.CoursesManagementApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoursesManagementApp.dao.StudentRegistrationDAO;
import com.example.CoursesManagementApp.entity.StudentRegistration;

@Service
public class StudentRegistrationImpl implements StudentRegistrationService {

	@Autowired
	private StudentRegistrationDAO studentRepository;
	
	@Autowired
	public StudentRegistrationImpl(StudentRegistrationDAO theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	public StudentRegistrationImpl() {
		
	}
	
	@Override
	@Transactional
	public List<StudentRegistration> findRegistrationsByCourseId(int course_id){
		return studentRepository.findRegistrationsByCourseId(course_id);
	}
	
	@Override
	@Transactional
	public StudentRegistration find(int student_id) {
		return studentRepository.find(student_id);
	}
	
	@Override
	@Transactional
	public void delete(int student_id) {
		studentRepository.delete(student_id);
	}
	
	@Override
	@Transactional
	public void save(StudentRegistration student, int course_id) {
		studentRepository.save(student, course_id);
	}
	
	@Override
	@Transactional
	public void update(StudentRegistration student) {
		studentRepository.update(student);
	}
}
