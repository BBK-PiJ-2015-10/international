package com.allpago;

import com.allpago.delivery.calculator.Coordinator;
import com.allpago.delivery.calculator.source.Source;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//https://medium.com/edureka/what-is-dependency-injection-5006b53af782

@SpringBootApplication
public class AllpagoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context  = SpringApplication.run(AllpagoApplication.class, args);
        Source c = context.getBean(Source.class);
        c.load();

    }

}
