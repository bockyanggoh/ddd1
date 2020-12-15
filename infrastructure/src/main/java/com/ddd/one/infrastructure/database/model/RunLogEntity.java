package com.ddd.one.infrastructure.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_run_cycle_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunLogEntity extends BaseEntity {
    @Column(name = "run_log_aggregate_id", unique = true, columnDefinition = "varchar(36)")
    private String runAggregateId;
    @Column(name = "event_type", columnDefinition = "varchar(100)")
    private String eventType;
    @Column(name = "event_description")
    private String eventDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    private RunCycleEntity runCycle;
}
