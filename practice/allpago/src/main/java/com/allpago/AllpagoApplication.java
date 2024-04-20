package com.allpago;

import com.allpago.delivery.calculator.DeliveryCostCalculator;
import com.allpago.delivery.calculator.Executor;
import com.allpago.delivery.calculator.shipment.Shipment;
import com.allpago.delivery.calculator.source.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//https://medium.com/edureka/what-is-dependency-injection-5006b53af782

@SpringBootApplication
public class AllpagoApplication {

    private static Logger logger = LoggerFactory.getLogger(AllpagoApplication.class);

    public static void main(String[] args) {

        var sourceDirectory = "allpago/src/main/resources/input/";
        ConfigurableApplicationContext context = SpringApplication.run(AllpagoApplication.class, args);
        Executor executor = context.getBean(Executor.class);
        executor.execute(sourceDirectory);

    }

}
