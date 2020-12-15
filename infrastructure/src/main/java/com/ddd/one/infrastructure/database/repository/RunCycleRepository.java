package com.ddd.one.infrastructure.database.repository;

import com.ddd.one.infrastructure.database.model.RunCycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RunCycleRepository extends JpaRepository<RunCycleEntity, Long> {
    Optional<RunCycleEntity> findRunCycleEntityByRunAggregateId(String runAggregateId);
}
