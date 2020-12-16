package com.ddd.one.domain.aggregate.run.saga;

import org.axonframework.modelling.saga.repository.SagaStore;
import org.axonframework.modelling.saga.repository.jdbc.JdbcSagaStore;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.context.annotation.Bean;

@Saga(sagaStore = "runCycleSaga")
public class RunCycleSaga {

}
