package com.example.CoursesManagementApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CoursesManagementApp.dao.CourseDAO;
import com.example.CoursesManagementApp.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseRepository;
	
	private ArrayList<StatisticStrategy> statCalculationStrategies = new ArrayList<StatisticStrategy>();
	private ArrayList<String> statName = new ArrayList<String>();
	
	@Autowired
	public CourseServiceImpl(CourseDAO theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	
	public CourseServiceImpl() {
		
	}
	
	@Override
	@Transactional
	public HashMap<String, Double> getCourseStatistics(Course course){
		HashMap<String, Double> stats = new HashMap<String, Double>();
		
		setStatCalculationStrategies();
		
		for (int i=0; i < statName.size(); i++) {
			stats.put(statName.get(i), statCalculationStrategies.get(i).calculateStatistic(course));
		}
		
		return stats;
	}
	
	public List<StatisticStrategy> getStatCalculationStrategies(){
		return statCalculationStrategies;
	}
	
	public void setStatCalculationStrategies() {
		statCalculationStrategies.add(new MinStatisticStrategy());
		statName.add("Min");
		
		statCalculationStrategies.add(new MaxStatisticStrategy());
		statName.add("Max");
		
		statCalculationStrategies.add(new MeanStatisticStrategy());
		statName.add("Mean");
		
		statCalculationStrategies.add(new StandardDeviationStatisticStrategy());
		statName.add("Standard Deviation");
		
		statCalculationStrategies.add(new VarianceStatisticStrategy());
		statName.add("Variance");
		
		statCalculationStrategies.add(new PercentilesStatisticStrategy());
		statName.add("Percentiles");
		
		statCalculationStrategies.add(new SkewnessStatisticStrategy());
		statName.add("Skewness");
		
		statCalculationStrategies.add(new KurtosisStatisticStrategy());
		statName.add("Kurtosis");
		
		statCalculationStrategies.add(new MedianStatisticStrategy());
		statName.add("Median");
	}
	
	public ArrayList<String> getStatName() {
		return statName;
	}

	public void setStatName(ArrayList<String> statName) {
		this.statName = statName;
	}

	@Override
	@Transactional
	public List<Course> findCourseByInstructorLogin(String instructor){
		return courseRepository.findCourseByInstructorLogin(instructor);
	}
	
	@Override
	@Transactional
	public Course find(int course_id) {
		return courseRepository.find(course_id);
	}
	
	@Override
	@Transactional
	public void delete(int course_id) {
		courseRepository.delete(course_id);
	}
	
	@Override
	@Transactional
	public void save(Course course) {
		courseRepository.save(course);
	}
	
	@Override
	@Transactional
	public void update(Course course) {
		courseRepository.update(course);
	}
}
