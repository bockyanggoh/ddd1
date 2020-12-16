package com.ddd.one.domain.external;

import com.ddd.one.domain.aggregate.run.command.CreateRunCommand;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExternalRunListener {

    @KafkaListener(topics = "local.run")
    private void handle(String message) {
        AggregateLifecycle.apply(new CreateRunCommand(message));
    }


}
