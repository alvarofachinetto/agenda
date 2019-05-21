package com.evento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evento.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	@Query("select u from Usuario u where u.email = ?1 and u.senha = ?1")
	Usuario findByUsuario(String email, String senha);
}
