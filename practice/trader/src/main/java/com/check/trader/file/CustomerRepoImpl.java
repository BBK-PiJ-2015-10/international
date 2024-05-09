package com.check.trader.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Component
public class CustomerRepoImpl implements CustomerRepo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String fileName;

    public CustomerRepoImpl(@Value("${customers.file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Customers> fetchCustomers() {
        logger.info("Start fetch customers from {}", fileName);

        var path = Paths.get(fileName);

        String data = "";

        try {
            data = Files.readString(path);
        } catch (IOException e) {
            logger.error("Error reading data due to {}", data);
        }

        var customersString = Arrays.asList(data.split("\\R"));

        logger.info("Read data: {} with size {}", data, customersString.size());

        return List.of();
    }


}
