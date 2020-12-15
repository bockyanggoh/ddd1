package com.ddd.one.domain.aggregate.run.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpireRunCommand {
    @TargetAggregateIdentifier
    private String runId;
    private LocalDateTime expiryTime;
}
