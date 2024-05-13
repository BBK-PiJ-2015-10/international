package com.check.trader.dto;

public record Strategy(int id, int minRiskLevel,int maxRiskLevel,int minYearsToRetirement,
                       int maxYearsToRetirement,double stockPercentage, double cashPercentage, double bondsPercentage) {
}
