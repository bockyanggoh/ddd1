package com.ddd.one.domain.aggregate;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseAggregate implements Serializable {

    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;
    private String createdBy;
    private String updatedBy;

    public BaseAggregate() {
        var datetime = LocalDateTime.now();
        createdTs = datetime;
        createdBy = "SYSTEM";
        updatedTs = datetime;
        updatedBy = "SYSTEM";
    }

    private void updateAudit(LocalDateTime updatedTs, String updatedBy) {
        this.updatedTs = updatedTs;
        this.updatedBy = updatedBy;
    }
}
