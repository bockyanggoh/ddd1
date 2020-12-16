package com.ddd.one.domain.projections;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.ddd.one.domain.aggregate.run.deadline.RunExpiredDeadline;
import com.ddd.one.domain.aggregate.run.event.RunCreatedEvent;
import com.ddd.one.domain.aggregate.run.event.RunLogAddedEvent;
import com.ddd.one.infrastructure.database.model.RunCycleEntity;
import com.ddd.one.infrastructure.database.model.RunLogEntity;
import com.ddd.one.infrastructure.database.repository.RunCycleRepository;
import lombok.AllArgsConstructor;
import org.axonframework.deadline.DeadlineManager;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@AllArgsConstructor
@XRayEnabled
public class RunProjection {
    private RunCycleRepository repository;
    private DeadlineManager deadlineManager;

    @EventHandler
    private void handle(RunCreatedEvent event) {
        var entity = new RunCycleEntity(event.getRunId(),event.getRunName());
        repository.save(entity);
        deadlineManager.schedule(Duration.ofSeconds(10), "expire",
                new RunExpiredDeadline(entity.getRunAggregateId())
                );
    }

    @EventHandler
    private void handle(RunLogAddedEvent event) throws InterruptedException {
        var retrieved = repository.findRunCycleEntityByRunAggregateId(event.getRunId());
        if(retrieved.isPresent()) {
            var entity = retrieved.get();
            var runLogEntity = new RunLogEntity(event.getRunLogId(), event.getEventType(), event.getEventDescription(), entity);
            entity.addRunLog(runLogEntity);
            repository.save(entity);
        }
    }
}
