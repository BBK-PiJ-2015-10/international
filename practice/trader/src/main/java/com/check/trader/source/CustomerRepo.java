package com.check.trader.source;

import com.check.trader.entity.ImportedCustomer;

import java.util.List;

public interface CustomerRepo {

    List<ImportedCustomer> fetchCustomers();

}
