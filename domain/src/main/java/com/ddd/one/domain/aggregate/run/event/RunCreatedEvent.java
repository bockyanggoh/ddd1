package com.ddd.one.domain.aggregate.run.event;

import lombok.*;

@Value
@AllArgsConstructor
public class RunCreatedEvent {
    String runId;
    String runName;
}
