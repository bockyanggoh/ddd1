package com.ddd.one.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "com.ddd.one.infrastructure",
                "com.ddd.one.domain",
                "org.axonframework.springboot.autoconfig"
        }
)

@EnableJpaRepositories(basePackages = {
        "com.ddd.one.infrastructure.database",
})
@EntityScan(basePackages = {
        "com.ddd.one.infrastructure.database.model",
        "org.axonframework.modelling.saga.repository.jpa",
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa"
})

public class JavaOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaOneApplication.class, args);
    }

}
