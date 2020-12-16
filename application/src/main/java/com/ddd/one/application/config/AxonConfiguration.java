package com.ddd.one.application.config;

import org.axonframework.spring.eventhandling.scheduling.quartz.QuartzEventSchedulerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfiguration {
    @Bean
    public QuartzEventSchedulerFactoryBean eventScheduler() {
        return new QuartzEventSchedulerFactoryBean();
    }

}
