package com.ddd.one.domain.aggregate.run.deadline;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RunExpiredDeadline {
    String aggregateId;
}
