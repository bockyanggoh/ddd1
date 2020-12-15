package com.ddd.one.infrastructure.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_run_cycle")
@NoArgsConstructor
@Data
public class RunCycleEntity extends BaseEntity{
    @Column(name = "run_aggregate_id", columnDefinition = "varchar(36)", unique = true)
    private String runAggregateId;
    @Column(name = "run_name", columnDefinition = "varchar(150)", unique = true)
    private String runName;
    @Column(name = "run_termination_ts")
    private LocalDateTime runTerminationTs;
    @OneToMany(
            mappedBy = "runCycle",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RunLogEntity> runLogs;

    public RunCycleEntity(String runAggregateId, String runName) {
        this.runAggregateId = runAggregateId;
        this.runName = runName;
        this.runLogs = new ArrayList<>();
    }

    public void addRunLog(RunLogEntity log) {
        this.runLogs.add(log);
    }
}
