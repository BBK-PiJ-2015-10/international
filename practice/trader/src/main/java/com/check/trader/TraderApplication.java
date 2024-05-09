package com.check.trader;

import com.check.trader.file.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://github.com/Torwalt/fintechCodingChallange

@SpringBootApplication
public class TraderApplication {

    public static void main(String[] args) {

        var applicationContext = SpringApplication.run(TraderApplication.class, args);

        var customerRepo = applicationContext.getBean(CustomerRepo.class);

        customerRepo.fetchCustomers();


    }

}
