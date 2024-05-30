package com.check.trader.entity;

import java.time.LocalDate;

public record Customer(int id, String email, LocalDate dateOfBirth, int riskLevel, int retirementAge,
                       int yearToRetirement, ImportedStrategy importedStrategy) {
}
