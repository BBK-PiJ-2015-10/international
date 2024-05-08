package com.check.trader.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Customers {

    private int customerId;

    private String email;

    private Date dateOfBirth;

    private int riskLevel;

    private int retirementAge;

}
