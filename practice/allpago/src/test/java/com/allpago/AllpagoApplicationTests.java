package com.allpago;

import com.allpago.delivery.calculator.Executor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootTest
class AllpagoApplicationTests {

    @Autowired
    ConfigurableApplicationContext context;

    @Test
    void contextLoads() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input").getFile());

        var sourceDirectory = file.getPath().toString();

        Executor executor = context.getBean(Executor.class);
        executor.execute(sourceDirectory);

    }

}
