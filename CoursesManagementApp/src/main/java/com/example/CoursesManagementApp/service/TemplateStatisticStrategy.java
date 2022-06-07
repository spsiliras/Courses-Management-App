package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import com.example.CoursesManagementApp.entity.Course;

public abstract class TemplateStatisticStrategy implements StatisticStrategy {

	public TemplateStatisticStrategy() {
		
	}
	
	public double calculateStatistic(Course course) {
		DescriptiveStatistics ds = new DescriptiveStatistics();
		
		prepareDataSet(course, ds);
		
		return doActualCalculation(ds);
	}
	
	private void prepareDataSet(Course course, DescriptiveStatistics ds) {
		
		for (int i=0; i<course.getStudents().size(); i++) {
			ds.addValue(course.getStudents().get(i).getGrade());
		}
	}
	
	protected abstract double doActualCalculation(DescriptiveStatistics ds);
}
