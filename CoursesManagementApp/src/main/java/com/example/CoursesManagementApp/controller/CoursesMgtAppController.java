package com.example.CoursesManagementApp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CoursesManagementApp.entity.Course;
import com.example.CoursesManagementApp.entity.StudentRegistration;
import com.example.CoursesManagementApp.service.CourseService;
import com.example.CoursesManagementApp.service.StudentRegistrationService;

@Controller
@RequestMapping("/courses")
public class CoursesMgtAppController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentRegistrationService studentRegistrationService;
	
	private String instructor;
	
	@Autowired
	public CoursesMgtAppController(CourseService theCourseService, StudentRegistrationService theStudentRegistrationService) {
		courseService = theCourseService;
		studentRegistrationService = theStudentRegistrationService;
	}
	
	@RequestMapping("/login")
	public String login(Model theModel) {
		Course course = new Course();
		
		theModel.addAttribute("course", course);
		
		return "login";
	}
	
	@RequestMapping("/login/save")
	public String saveInstructor(@ModelAttribute("course") Course theCourse) {
		instructor = theCourse.getInstructor();
		
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/list")
	public String listCourses(Model theModel) {
		
		List<Course> theCourses = courseService.findCourseByInstructorLogin(instructor);
		
		theModel.addAttribute("courses", theCourses);
		
		return "courses/list-courses";
	}
	
	@RequestMapping("/showFormForAddCourse")
	public String showFormForAddCourse(Model theModel) {
		
		Course theCourse = new Course();
		theModel.addAttribute("course", theCourse);
		
		return "courses/course-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int course_id, Model theModel) {
		
		Course theCourse = courseService.find(course_id);
		
		theModel.addAttribute("course", theCourse);
		
		return "courses/course-form";			
	}
	
	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		theCourse.setInstructor(instructor);
		
		if (courseService.find(theCourse.getCourse_id()) == null) {
			courseService.save(theCourse);
		}
		
		else {
			courseService.update(theCourse);
		}
		
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/delete")
	public String deleteCourse(@RequestParam("courseId") int course_id) {
		
		courseService.delete(course_id);
		
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/showStatistics")
	public String showStatistics(@RequestParam("courseId") int course_id, Model theModel) {
		
		Course theCourse = courseService.find(course_id);
		HashMap<String, Double> stats = courseService.getCourseStatistics(theCourse);
		
		theModel.addAttribute("statistics", stats);
		
		return "statistics/statistics-list";
	}
	
	@RequestMapping("/students/list")
	public String listStudents(@RequestParam("courseId") int course_id, Model theModel) {
		List<StudentRegistration> theStudents = studentRegistrationService.findRegistrationsByCourseId(course_id);
		
		theModel.addAttribute("students", theStudents);
		
		return "students/list-students";
	}
	
	@RequestMapping("/students/showFormForAddStudent")
	public String showFormForAddStudent(Model theModel) {
		StudentRegistration theStudent = new StudentRegistration();
		theModel.addAttribute("student", theStudent);
		
		return "students/student-form";
	}
	
	@RequestMapping("/students/showFormForUpdate")
	public String showFormForUpdateStudent(@RequestParam("studentId") int student_id, Model theModel) {
		
		StudentRegistration theStudent = studentRegistrationService.find(student_id);
		
		theModel.addAttribute("student", theStudent);
		
		return "students/student-form";			
	}
	
	@RequestMapping("/students/save")
	public String saveCourse(@ModelAttribute("student") StudentRegistration theStudent, @RequestParam("courseId") int course_id) {
		
		theStudent.setGrade();
		
		if (studentRegistrationService.find(theStudent.getStudent_id()) == null) {
			studentRegistrationService.save(theStudent, course_id);
		}
		
		else {
			studentRegistrationService.update(theStudent);
		}
		
		return "redirect:/courses/list";
	}
	
	@RequestMapping("/students/delete")
	public String deleteStudent(@RequestParam("studentId") int student_id) {
		studentRegistrationService.delete(student_id);
		
		return "redirect:/courses/list";
	}
}
