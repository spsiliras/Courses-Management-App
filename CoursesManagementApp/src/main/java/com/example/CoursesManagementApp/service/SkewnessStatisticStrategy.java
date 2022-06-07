package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class SkewnessStatisticStrategy extends TemplateStatisticStrategy{

	public SkewnessStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getSkewness();
	}

}
