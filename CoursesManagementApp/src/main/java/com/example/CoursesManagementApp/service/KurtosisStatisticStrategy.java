package com.example.CoursesManagementApp.service;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class KurtosisStatisticStrategy extends TemplateStatisticStrategy{

	public KurtosisStatisticStrategy() {
		
	}
	
	@Override
	protected double doActualCalculation(DescriptiveStatistics ds) {
		return ds.getKurtosis();
	}

}
