package com.anmv.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KeyMessageProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String key, String value) {
		kafkaTemplate.send("multiple-partition-topic", key, value);
	}
}
