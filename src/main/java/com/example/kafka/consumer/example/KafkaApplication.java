package com.example.kafka.consumer.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.kafka.consumer.example.model.Greeting;
import com.example.kafka.consumer.example.service.MessageConsumerService;
import com.example.kafka.consumer.example.service.MessageProducerService;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
        
        MessageProducerService producer = context.getBean(MessageProducerService.class);
        MessageConsumerService listener = context.getBean(MessageConsumerService.class);
        
        producer.sendMessage("Hello, World!");

        //for (int i = 0; i < 5; i++) {
        //    producer.sendMessageToPartion("Hello To Partioned Topic!", i);
        //}
        //listener.partitionLatch.await(10, TimeUnit.SECONDS);

        //producer.sendMessageToFiltered("Hello Baeldung!");
        //producer.sendMessageToFiltered("Hello World!");
        //listener.filterLatch.await(10, TimeUnit.SECONDS);

        //producer.sendGreetingMessage(new Greeting("Greetings", "World!"));
        
       
        //listener.greetingLatch.await(10, TimeUnit.SECONDS);

        context.close();
    }
}
