package com.example.kafka.consumer.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
