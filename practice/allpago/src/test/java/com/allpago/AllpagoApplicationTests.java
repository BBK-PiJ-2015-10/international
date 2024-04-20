package com.allpago;

import com.allpago.delivery.calculator.Executor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootTest
@SpringBootTest
class AllpagoApplicationTests {

    @Autowired
    Executor executor;

    @Test
    void contextLoads() {

        var sourceDirectory = "allpago/src/main/resources/input/";

        //ConfigurableApplicationContext context  = SpringApplication.run(AllpagoApplication.class);
        //var result = executor.execute(sourceDirectory);
        //  Coordinator c = coordinator;
        //c.execute();

    }

}
