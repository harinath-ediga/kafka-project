package com.taanvi.kafka_project.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class MessageProducer {

    private Logger log = LoggerFactory.getLogger(MessageProducer.class);

    //@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${myapp.kafka.topic}")
    private String topic;

    String[] ayanshArray;

    public void sendMessage(String message) {
        ayanshArray = new String[100000];
        log.info("MESSAGE SENT FROM PRODUCER END -> " + message);
        IntStream.range(0, 99999).mapToObj(value -> ayanshArray[value] = value + "Ayansh" + " Taanvi "+ "AAAAAAAAAAA" ).collect(Collectors.joining());
        for (String s :
                ayanshArray) {
            System.out.println(s);
        }
        //kafkaTemplate.send(topic, message);
    }

    public void clear(){
        ayanshArray = null;
    }
}
