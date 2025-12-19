package com.example.patient_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Byte[]> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
}
