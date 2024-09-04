package com.anmv.kafka;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import com.anmv.kafka.entity.Employee;
import com.anmv.kafka.producer.EmployeeJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anmv.kafka.producer.HelloKafkaProducer;
import com.anmv.kafka.producer.KeyMessageProducer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling /* This one for @Scheduled can run */
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private HelloKafkaProducer helloProducer;

    @Autowired
    private KeyMessageProducer keyProducer;

    @Autowired
    private EmployeeJsonProducer employeeJsonProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		This code for HelloProducer
//		helloProducer.sendHello("Time = " + ThreadLocalRandom.current().nextInt());


//		 This code for KeyProducer
//        for (int i = 0; i < 300; i++) {
//            String key = "key-" + (i % 3);
//            String value = "value = " + i + " with key = " + key;
//			keyProducer.send(key, value);
//        }


//        This code for EmployeeJsonProducer
//        for (int i = 0; i < 10; i++) {
//            var employee = new Employee("emp-" + i, "Employee " + i, LocalDate.now());
//            employeeJsonProducer.sendMessage(employee);
//        }
    }

}
