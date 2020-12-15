package com.ddd.one.domain.aggregate.run.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRunCommand {

    @TargetAggregateIdentifier
    private String runId;
    private String runName;

    public CreateRunCommand(String runName) {
        this.runId = UUID.randomUUID().toString();
        this.runName = runName;
    }
}
