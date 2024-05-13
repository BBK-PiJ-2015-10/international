package com.check.trader.mapper;

import com.check.trader.dto.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(String customer) {
        var customerArray = customer.split(",");
        var customerId = Integer.valueOf(customerArray[0]);
        var email = customerArray[1];
        var dayOfBirth = LocalDate.parse(customerArray[2]);
        var riskLevel = Integer.valueOf(customerArray[3]);
        var retirementAge = Integer.valueOf(customerArray[4]);
        return new Customer(customerId, email, dayOfBirth, riskLevel, retirementAge);
    }
}
