package modelo.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Usuario;
import modelo.persistencia.UsuarioRepository;

@Service
public class GestorUsuario {	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void insertarUsuario(Usuario u) {
		usuarioRepository.save(u);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public List<Usuario> buscarApellido (String apellido){
		return usuarioRepository.findByApellido(apellido);
	}
	
}
