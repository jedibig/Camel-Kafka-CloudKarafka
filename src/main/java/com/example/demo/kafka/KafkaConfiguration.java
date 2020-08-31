package com.example.demo.kafka;

import com.example.demo.exception.ConfigurationException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
public class KafkaConfiguration {
    @Value("${cloudkarafka.topic}")
    private String topicName;
    private final String kafkaServer;

    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaServer = kafkaProperties.getBootstrapServers().stream().findAny().orElseThrow(ConfigurationException::new);;
    }

}
