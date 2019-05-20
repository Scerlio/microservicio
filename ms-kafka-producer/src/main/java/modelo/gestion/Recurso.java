package modelo.gestion;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cfg.KafkaConfig;
import modelo.entidades.Usuario;

@Service
@RestController
@Scope("request")
//@RequestMapping("index")
public class Recurso {

	private String TOPIC = "DOOM";	
	private static KafkaConfig kc = new KafkaConfig();
	
	
	// Se crea un logger para la clase
	Logger log = LoggerFactory.getLogger(Recurso.class);
	
	@PostMapping(path="/mandarUsuario")
	public ModelAndView mandarUsuario (@RequestParam("nombre") String nombre, 
			@RequestParam("apellido") String apellido) throws InterruptedException, ExecutionException {
		// Se usa para que la misma key siempre vaya a la misma particion

		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.setApellido(apellido);
		
		final Producer<String, Usuario> producer = kc.createProducer();
		
		ProducerRecord<String, Usuario> record = new ProducerRecord<String, Usuario>(TOPIC, u);
		
		// Operacion asincrona, añadimos un callback para recibir feedback del mensaje
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception e) {
				// Se ejecuta siempre que se manda o se genera una excepcion
				if (e == null) {
					log.info("\nMetadatos recibidos. Topic: " + metadata.topic() + " particion: "
						+ metadata.partition() + " offset: " + metadata.offset() 
						+ " key: " + record.key() + " time: " + metadata.timestamp());
				}
				
				else {
					log.error("Error", e);
				}
			}
		});
		
		System.out.printf("sent record(key=%s value=(%s)) ", record.key(), record.value());
		
		// Se necesita para forzar el envio
		producer.flush();
		// Flush and close
		producer.close();
		
		return new ModelAndView("redirect:http://localhost:8080/producer");
	}
	
}
