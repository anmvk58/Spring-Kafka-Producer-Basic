package com.anmv.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BalanceProducerDemo {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private AtomicInteger counter = new AtomicInteger(0);

//    @Scheduled(fixedRate = 1000)
    public void balanceProducer(){
        kafkaTemplate.send("t-rebalance", "Counter " + counter.incrementAndGet());
    }
}
