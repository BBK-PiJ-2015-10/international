package com.check.trader.mapper;

import com.check.trader.entity.Customer;
import com.check.trader.entity.ImportedCustomer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public ImportedCustomer toImportedCustomer(String customer) {
        var customerArray = customer.split(",");
        var customerId = Integer.valueOf(customerArray[0]);
        var email = customerArray[1];
        var dayOfBirth = LocalDate.parse(customerArray[2]);
        var riskLevel = Integer.valueOf(customerArray[3]);
        var retirementAge = Integer.valueOf(customerArray[4]);
        return new ImportedCustomer(customerId, email, dayOfBirth, riskLevel, retirementAge);
    }

    @Override
    public Customer toCustomer(ImportedCustomer importedCustomer) {
//        var customer = new Customer(importedCustomer.customerId()
//                ,importedCustomer.email(),
//                importedCustomer.dateOfBirth(),
//                importedCustomer.riskLevel(),
//                importedCustomer.retirementAge(),
//                5
//        )
        return null;
    }
}
