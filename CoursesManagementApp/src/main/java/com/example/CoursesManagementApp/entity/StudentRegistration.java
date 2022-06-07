package com.example.CoursesManagementApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_registrations")
public class StudentRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year_of_registration")
	private int year_of_registration;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="project")
	private double project;
	
	@Column(name="exam")
	private double exam;
	
	@Column(name="grade")
	private double grade;
	
	public StudentRegistration() {
		
	}

	public StudentRegistration(int student_id, String name, int year_of_registration, int semester) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.year_of_registration = year_of_registration;
		this.semester = semester;
	}

	public StudentRegistration(String name, int year_of_registration, int semester) {
		super();
		this.name = name;
		this.year_of_registration = year_of_registration;
		this.semester = semester;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear_of_registration() {
		return year_of_registration;
	}

	public void setYear_of_registration(int year_of_registration) {
		this.year_of_registration = year_of_registration;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public double getProject() {
		return project;
	}

	public void setProject(double project) {
		this.project = project;
	}

	public double getExam() {
		return exam;
	}

	public void setExam(double exam) {
		this.exam = exam;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade() {
		this.grade = 0.6*exam + 0.4*project;
	}

	@Override
	public String toString() {
		return "StudentRegistration [student_id=" + student_id + ", name=" + name
				+ ", year_of_registration=" + year_of_registration + ", semester=" + semester + "]";
	}
	
	

}
