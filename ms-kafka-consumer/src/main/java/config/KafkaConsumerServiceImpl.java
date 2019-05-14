package config;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerServiceImpl<T> {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerServiceImpl.class);

    @KafkaListener(topics="${testing.topic}")
    public void processMessage(T content) {        

        log.info("received content= '{}'", content);

        @SuppressWarnings("unchecked")
        ConsumerRecord<String, T> records = (ConsumerRecord<String, T>) content;
        log.info("records= {}", records.value());
    }
}