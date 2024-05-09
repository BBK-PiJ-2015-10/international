package com.check.trader.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Component
public class CustomerRepoImpl implements CustomerRepo{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String fileName;

    public CustomerRepoImpl(@Value("${customers.file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Customers> fetchCustomers() {
        logger.info("Start fetch customers from {}",fileName);

        return List.of();
    }


}
