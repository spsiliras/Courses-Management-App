package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class StandardDeviationStatisticStrategy extends TemplateStatisticStrategy {

	public StandardDeviationStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getStandardDeviation();
	}

}
