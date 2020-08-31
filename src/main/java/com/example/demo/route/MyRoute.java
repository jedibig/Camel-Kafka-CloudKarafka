package com.example.demo.route;

import com.example.demo.kafka.KafkaConfiguration;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MyRoute extends RouteBuilder {

    private KafkaConfiguration kafkaConfiguration;

    @Override
    public void configure() throws Exception {

        String kafka = "kafka:" + kafkaConfiguration.getTopicName();

        from("direct:foo").to("direct:hello");
    }
}
