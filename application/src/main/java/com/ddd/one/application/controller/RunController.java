package com.ddd.one.application.controller;

import com.ddd.one.application.model.request.CreateRunRequest;
import com.ddd.one.application.model.response.BaseResponse;
import com.ddd.one.domain.aggregate.run.command.CreateRunCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/api/v1/run")
@AllArgsConstructor
public class RunController {

    private final CommandGateway commandGateway;

    @GetMapping("/{runId}")
    public ResponseEntity getRunApi(@PathVariable String runId) {
        throw new NotYetImplementedException();
    }

    @PutMapping
    public ResponseEntity<BaseResponse> idempotentUpdateRunApi(@RequestBody CreateRunRequest request) {
        String createdId = commandGateway.sendAndWait(new CreateRunCommand(request.getRunName()));
        return ResponseEntity.ok(new BaseResponse(createdId));
    }

    @DeleteMapping("/{runId}")
    public ResponseEntity deleteRunApi(@PathVariable String runId) {
        throw new NotYetImplementedException();
    }

    @PutMapping("/{runId}/logs")
    public ResponseEntity addRunLogApi(@PathVariable String runId, @RequestBody String request) {
        throw new NotYetImplementedException();
    }
}
