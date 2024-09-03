package com.anmv.kafka;

import com.anmv.kafka.producer.HelloKafkaProducer;
import com.anmv.kafka.producer.KeyMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
//	private HelloKafkaProducer producer;
    private KeyMessageProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      this code below for Hello World Example
//		producer.sendMessage("This time is = " + ThreadLocalRandom.current().nextInt());

//        this code below for multiple partition topic
        for (int i = 0; i < 100; i++) {
            String key = "key=" + (i % 3);
            String value = "value=" + i + " with key=" + key;
            producer.sendMessage(key, value);
        }

    }
}
