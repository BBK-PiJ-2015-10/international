package com.check.trader.entity;

public record ImportedStrategy(int id, int minRiskLevel, int maxRiskLevel, int minYearsToRetirement,
                               int maxYearsToRetirement, double stockPercentage, double cashPercentage, double bondsPercentage) {
}
