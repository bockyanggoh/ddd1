package com.ddd.one.domain.aggregate.run.deadline;

import com.ddd.one.domain.aggregate.run.command.ExpireRunCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.deadline.annotation.DeadlineHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class RunCycleDeadline {

    private CommandGateway gateway;

    @DeadlineHandler(deadlineName = "expire")
    public void on(RunExpiredDeadline payload) {
        gateway.send(new ExpireRunCommand(payload.getAggregateId(), LocalDateTime.now()));
    }
}
