package com.database.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ApplicationContext applicationContext) {
        return (args) -> {
            log.info("Application started:");
            log.info("------------------");
            Arrays.stream(applicationContext.getBeanDefinitionNames()).sorted()
                    .forEach(beanName -> System.out.println(beanName));

            //jpaCommandLine();

            //executeCommandLine();
        };
    }
}
