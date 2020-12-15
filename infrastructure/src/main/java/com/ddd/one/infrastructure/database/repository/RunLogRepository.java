package com.ddd.one.infrastructure.database.repository;

import com.ddd.one.infrastructure.database.model.RunLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunLogRepository extends JpaRepository<RunLogEntity, Long> {
}
