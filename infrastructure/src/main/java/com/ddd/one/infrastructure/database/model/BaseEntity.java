package com.ddd.one.infrastructure.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Version
    @Column(name = "version")
    private Integer version;
    @CreationTimestamp
    @Column(name = "created_ts")
    private LocalDateTime createdTs;
    @CreationTimestamp
    @Column(name = "updated_ts")
    private LocalDateTime updatedTs;
    @Column(columnDefinition = "varchar(50) default 'SYSTEM'")
    private String createdBy;
    @Column(columnDefinition = "varchar(50) default 'SYSTEM'")
    private String updatedBy;
}
