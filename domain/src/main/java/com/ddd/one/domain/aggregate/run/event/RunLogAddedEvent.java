package com.ddd.one.domain.aggregate.run.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RunLogAddedEvent {
    String runId;
    String runLogId;
    String eventType;
    String eventDescription;
}
