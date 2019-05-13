package modelo.gestion;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import modelo.entidades.Usuario;

public class UsuarioDeserializer extends JsonDeserializer<Usuario> {
	
	public UsuarioDeserializer() {
		super(Usuario.class);
	}

}
