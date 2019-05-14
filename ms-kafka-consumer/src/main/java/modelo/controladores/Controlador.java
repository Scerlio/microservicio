package modelo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.entidades.Usuario;
import modelo.gestion.GestorUsuario;

@RestController
public class Controlador {

	@Autowired
	private GestorUsuario gu;
	
	public void guardarUsuario(Usuario usuario) {
		gu.insertarUsuario(usuario);
	}
	
	@GetMapping("/listar")
	public  List<Usuario> listarUsuarios() {
		return gu.listar();
	}

}
