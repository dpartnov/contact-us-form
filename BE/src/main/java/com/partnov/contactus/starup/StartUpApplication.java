package com.partnov.contactus.starup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.partnov.contactus.*")
@EntityScan("com.partnov.contactus.*")
@EnableJpaRepositories(basePackages = "com.partnov.contactus.repository")
public class StartUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class, args);
    }

}
