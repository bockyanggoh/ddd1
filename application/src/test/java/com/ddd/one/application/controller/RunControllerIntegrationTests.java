package com.ddd.one.application.controller;

import com.ddd.one.application.model.request.CreateRunRequest;
import com.ddd.one.infrastructure.database.repository.RunCycleRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
@Slf4j
public class RunControllerIntegrationTests {

    @Value("${axon.kafka.default-topic}:local.event")
    private static String defaultTopic;

//    @ClassRule
//    public static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("wurstmeister/kafka").asCompatibleSubstituteFor("confluentinc/cp-kafka"))
//            .withEmbeddedZookeeper()
//            .withEnv("KAFKA_CREATE_TOPICS", defaultTopic)
//            .withExposedPorts(9093);

    @Autowired
    private RunController controller;

    @Autowired
    private RunCycleRepository repository;

    @Autowired
    private Gson gson;
    @Test
    @Order(1)
    public void CreateRunTest() throws InterruptedException {
        var randomName = UUID.randomUUID().toString();
        var result = controller.idempotentUpdateRunApi(new CreateRunRequest(randomName));
        Assert.assertTrue(result.getStatusCode().is2xxSuccessful());
        log.info(result.getBody().getId());
        Thread.sleep(100);
        var retrieved = repository.findRunCycleEntityByRunAggregateId(result.getBody().getId());
        Assert.assertTrue(retrieved.isPresent());
        Assert.assertEquals(result.getBody().getId(), retrieved.get().getRunAggregateId());
    }

}
