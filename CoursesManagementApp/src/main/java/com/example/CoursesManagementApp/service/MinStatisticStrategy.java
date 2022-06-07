package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MinStatisticStrategy extends TemplateStatisticStrategy{

	public MinStatisticStrategy() {
		
	}

	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getMin();
	}
}
