package com.anmv.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

//    We can config Producer at here
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        var properties = kafkaProperties.buildProducerProperties(null);

        properties.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, "180000");

        return new DefaultKafkaProducerFactory<>(properties);
    }

//    And we can create new bean of kafkaTemplate base on new config
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
