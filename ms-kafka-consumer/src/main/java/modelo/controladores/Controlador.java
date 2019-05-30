package modelo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@CrossOrigin("http://localhost:80")
	public  List<Usuario> listarUsuarios() {
		return gu.listar();
	}
	
	@GetMapping("/buscar")
	public  List<Usuario> buscarUsuariosApellido(@RequestParam String apellido) {
		return gu.buscarApellido(apellido);
	}

}
