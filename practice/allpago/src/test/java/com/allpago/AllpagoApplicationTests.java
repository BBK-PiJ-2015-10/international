package com.allpago;

import com.allpago.delivery.calculator.Coordinator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class AllpagoApplicationTests {

    @Autowired
    Coordinator coordinator;

    @Test
    void contextLoads() {

        //ConfigurableApplicationContext context  = SpringApplication.run(AllpagoApplication.class, args);
        Coordinator c = coordinator;
        c.execute();

    }

}
