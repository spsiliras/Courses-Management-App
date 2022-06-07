package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MaxStatisticStrategy extends TemplateStatisticStrategy {

	public MaxStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getMax();
	}

}
