package config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import modelo.entidades.Usuario;
import modelo.gestion.UsuarioDeserializer;

@Configuration @EnableKafka
public class KafkaConfig {

	private static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";
	//private static String BOOTSTRAP_SERVERS = "http://kafka1:19092,http://kafka2:19093,http://kafka3:19094";
	
	@Bean
	public static ConsumerFactory<String, Usuario> createConsumer() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG ,"DoomConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UsuarioDeserializer.class.getName());
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		return new DefaultKafkaConsumerFactory<>(props,new StringDeserializer(),new UsuarioDeserializer());
	} 

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Usuario> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Usuario> factory = 
        		new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(createConsumer());
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }
}
