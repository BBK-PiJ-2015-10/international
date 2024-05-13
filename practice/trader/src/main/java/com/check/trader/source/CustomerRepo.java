package com.check.trader.source;

import com.check.trader.dto.Customer;

import java.util.List;

public interface CustomerRepo {

    List<Customer> fetchCustomers();

}
