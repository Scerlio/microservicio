package modelo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;

import modelo.entidades.Usuario;
import modelo.gestion.GestorUsuario;

@RestController("consumer")
public class Controlador {

	@Autowired
	private GestorUsuario gu;
	
	public String guardarUsuario(Usuario usuario) {
		gu.insertarUsuario(usuario);
		return "Guardado";
	}
	
	@Bean
	@GetMapping(path="/listar")
	public  List<Usuario> listarUsuarios() {
		return gu.listar();
	}

}
