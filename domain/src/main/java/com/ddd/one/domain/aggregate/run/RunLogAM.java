package com.ddd.one.domain.aggregate.run;

import com.ddd.one.domain.aggregate.BaseAggregate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunLogAM extends BaseAggregate {

    @EntityId
    private String logId;
    private String eventType;
    private String eventDescription;

    public RunLogAM(String eventType, String eventDescription) {
        this.eventType = eventType;
        this.eventDescription = eventDescription;
    }
}
