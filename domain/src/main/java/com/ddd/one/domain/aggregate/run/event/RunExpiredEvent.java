package com.ddd.one.domain.aggregate.run.event;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
public class RunExpiredEvent {
    String runId;
    LocalDateTime expiryTime;
}
