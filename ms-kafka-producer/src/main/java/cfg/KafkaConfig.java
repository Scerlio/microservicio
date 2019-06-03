package cfg;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonSerializer;

import modelo.entidades.Usuario;

@EnableKafka @Configuration
public class KafkaConfig {

	private static String BOOTSTRAP_SERVERS = "http://kafka1:19092,http://kafka2:19093,http://kafka3:19094";	
	//private static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";	

	@Bean
	public Producer<String, Usuario> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "DoomProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

		return new KafkaProducer<>(props);
	}
}
