package modelo.controladores;

import java.time.Duration;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import config.KafkaConfig;
import modelo.entidades.Usuario;

@EnableKafka @Component
public class Recurso    {


	private static Logger log = LoggerFactory.getLogger(Recurso.class.getName());
	@Autowired
	static KafkaConfig kc;
	@Autowired
	private Controlador controlador;

	@KafkaListener(topics = "DOOM")
	@Bean 
	public void recibirUsuario() {
		final Consumer<String, Usuario> consumer = kc.createConsumer();

		ConsumerRecords<String, Usuario> records =consumer.poll(Duration.ofSeconds(3));
		for(ConsumerRecord<String, Usuario> r : records) {

			log.info("\nKey: " + r.key() + ", Value: " +  r.value());
			log.info("\nPatricion: " + r.partition() + ", offset: " + r.offset());

			Usuario u = r.value();
			System.out.println("\nGuardar: " + u + "\n");

			controlador.guardarUsuario(r.value());
		}		
	}
}
