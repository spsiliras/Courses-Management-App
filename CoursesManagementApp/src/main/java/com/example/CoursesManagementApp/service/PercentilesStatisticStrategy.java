package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class PercentilesStatisticStrategy extends TemplateStatisticStrategy {

	public PercentilesStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getPercentile(60);
	}

}
