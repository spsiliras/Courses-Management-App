package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MeanStatisticStrategy extends TemplateStatisticStrategy {
	
	public MeanStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getMean();
	}

}
