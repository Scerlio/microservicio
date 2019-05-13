package modelo.persistencia;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import modelo.entidades.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	List<Usuario> findByApellido(String apellido);
}