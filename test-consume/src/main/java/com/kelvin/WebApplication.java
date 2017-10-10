package com.kelvin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by tangshulei on 2017/8/17.
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication app = new SpringApplication(WebApplication.class);
        app.setBanner(null);
        app.run(args);
        Thread.sleep(1000000L * 1000);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot: ");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
