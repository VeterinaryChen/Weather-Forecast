package com.ls.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: jeffchen
 */
@SpringBootApplication(scanBasePackages = {"com.ls.spring.cloud"})
public class App {

    public static void main (String[] args) {
        SpringApplication.run(App.class,args);
        System.out.println("Hello");
    }

}
