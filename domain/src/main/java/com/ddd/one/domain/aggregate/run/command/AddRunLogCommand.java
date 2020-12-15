package com.ddd.one.domain.aggregate.run.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRunLogCommand {
    @TargetAggregateIdentifier
    private String runId;
    private String runLogId;
    private String eventType;
    private String eventDescription;

    public AddRunLogCommand(String runId, String eventType, String eventDescription) {
        this.runId = runId;
        this.runLogId = UUID.randomUUID().toString();
        this.eventType = eventType;
        this.eventDescription = eventDescription;
    }
}
