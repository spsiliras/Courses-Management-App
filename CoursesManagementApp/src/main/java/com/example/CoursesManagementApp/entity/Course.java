package com.example.CoursesManagementApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="instructor")
	private String instructor;
	
	@Column(name="year")
	private int year;
	
	@Column(name="semester")
	private int semester;
	
	@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JoinColumn(name="course_id", referencedColumnName="course_id")
	private List<StudentRegistration> students = new ArrayList<StudentRegistration>();

	public Course() {
		
	}
	
	public Course(int course_id, String name, String description, String instructor, int year, int semester) {
		this.course_id = course_id;
		this.name = name;
		this.description = description;
		this.instructor = instructor;
		this.year = year;
		this.semester = semester;
	}
	
	public Course(String name, String description, String instructor, int year, int semester) {
		this.name = name;
		this.description = description;
		this.instructor = instructor;
		this.year = year;
		this.semester = semester;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public List<StudentRegistration> getStudents() {
		return students;
	}

	public void setStudents(List<StudentRegistration> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", description=" + description + ", instructor="
				+ instructor + ", year=" + year + ", semester=" + semester + ", students=" + students + "]";
	}
	
	
}
