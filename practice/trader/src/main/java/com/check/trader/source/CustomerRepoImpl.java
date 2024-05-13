package com.check.trader.source;

import com.check.trader.dto.Customer;
import com.check.trader.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


@Component
public class CustomerRepoImpl implements CustomerRepo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String fileName;

    private CustomerMapper customerMapper;

    public CustomerRepoImpl(@Value("${customers.file.name}") String fileName, CustomerMapper customerMapper) {
        this.fileName = fileName;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> fetchCustomers() {
        logger.info("Start fetch customers from {}", fileName);
        var path = Paths.get(fileName);
        String data = "";
        try {
            data = Files.readString(path);
        } catch (IOException e) {
            logger.error("Error reading data due to {}", data);
        }
        List<String> customersString = new ArrayList<>(Arrays.asList(data.split("\\R")));
        customersString.remove(0);
        var customers = customersString.stream().map(cs -> customerMapper.toCustomer(cs)).collect(Collectors.toList());
        logger.info("Returning {} customers", customers.size());
        return customers;
    }

}
