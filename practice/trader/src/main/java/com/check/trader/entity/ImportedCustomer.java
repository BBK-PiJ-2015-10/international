package com.check.trader.entity;

import java.time.LocalDate;


public record ImportedCustomer(int customerId, String email, LocalDate dateOfBirth, int riskLevel, int retirementAge) {

}

//@RequiredArgsConstructor
//@Getter
//public class Customer {
//
//    private int customerId;
//
//    private String email;
//
//    private LocalDate dateOfBirth;
//
//    private int riskLevel;
//
//    private int retirementAge;
//
//}
