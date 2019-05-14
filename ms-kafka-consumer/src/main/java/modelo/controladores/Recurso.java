package modelo.controladores;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import config.KafkaConfig;
import modelo.entidades.Usuario;

@Component
public class Recurso<T> {


	private static Logger log = LoggerFactory.getLogger(Recurso.class.getName());
	@Autowired
	static KafkaConfig kc;
	@Autowired
	private Controlador controlador;

	@KafkaListener(topics = "DOOM")
	public void recibirUsuario(T content) {

		log.info("received content= '{}'", content);
		@SuppressWarnings("unchecked")
		ConsumerRecord<String, Usuario> records = (ConsumerRecord<String, Usuario>) content;


		log.info("\nKey: " + records.key() + ", Value: " +  records.value());
		log.info("\nPatricion: " + records.partition() + ", offset: " + records.offset());

		Usuario u = records.value();
		System.out.println("\nGuardar: " + u + "\n");

		controlador.guardarUsuario(records.value());
	}
}
