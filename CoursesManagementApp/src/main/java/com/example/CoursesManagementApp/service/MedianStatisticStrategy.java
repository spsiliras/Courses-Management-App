package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MedianStatisticStrategy extends TemplateStatisticStrategy {

	public MedianStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		//The 50th percentile is the median
		return ds.getPercentile(50);
	}

}
