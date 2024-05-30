package com.check.trader.mapper;

import com.check.trader.entity.Customer;
import com.check.trader.entity.ImportedCustomer;

public interface CustomerMapper {

    ImportedCustomer toImportedCustomer(String customer);

    Customer toCustomer(ImportedCustomer customer);


}
