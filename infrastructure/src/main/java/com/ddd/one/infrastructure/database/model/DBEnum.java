package com.ddd.one.infrastructure.database.model;

import lombok.Getter;

public class DBEnum
{
    @Getter
    public enum EventType {
        CREATE,
        UPDATE,
        QUERY,
        DELETE;
        private String name;
    }
}
