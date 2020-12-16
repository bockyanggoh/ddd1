package com.ddd.one.domain.aggregate.run;

import com.ddd.one.domain.aggregate.BaseAggregate;
import com.ddd.one.domain.aggregate.run.command.AddRunLogCommand;
import com.ddd.one.domain.aggregate.run.command.CreateRunCommand;
import com.ddd.one.domain.aggregate.run.command.ExpireRunCommand;
import com.ddd.one.domain.aggregate.run.event.RunCreatedEvent;
import com.ddd.one.domain.aggregate.run.event.RunExpiredEvent;
import com.ddd.one.domain.aggregate.run.event.RunLogAddedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.LifecycleProcessor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@EqualsAndHashCode(callSuper = true)
@Aggregate
@Data
@NoArgsConstructor
public class RunAggregate extends BaseAggregate {

    @AggregateIdentifier
    private String runId;
    private String runName;
    private LocalDateTime runTerminationTs;
    @AggregateMember
    private List<RunLogAM> runLogs;

    @CommandHandler
    public RunAggregate(CreateRunCommand command) {
        apply(new RunCreatedEvent(command.getRunId(), command.getRunName()));
    }

    @CommandHandler
    private void handle(AddRunLogCommand command) {
        apply(new RunLogAddedEvent(command.getRunId(), command.getRunLogId(), command.getEventType(), command.getEventDescription()));
    }

    @CommandHandler
    private void handle(ExpireRunCommand expireRunCommand) {
        apply(new RunExpiredEvent(expireRunCommand.getRunId(), expireRunCommand.getExpiryTime()));
    }

    @EventSourcingHandler
    private void on(RunCreatedEvent event) {
        this.runId = event.getRunId();
        this.runName = event.getRunName();
        this.runLogs = new ArrayList<>();
        this.runLogs.add(new RunLogAM(UUID.randomUUID().toString(), "CREATE", "DEFAULT EVENT"));
    }

    @EventSourcingHandler
    private void on(RunLogAddedEvent event) {
        this.runLogs.add(new RunLogAM(event.getRunLogId(), event.getEventType(), event.getEventDescription()));
    }
}
