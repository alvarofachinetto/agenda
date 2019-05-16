package com.evento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evento.model.Evento;

@Repository
@Transactional
public interface EventoRepository extends CrudRepository<Evento, Long>{
	@Query("select e from Evento e where e.usuario.codUsuario = ?1")
	public List <Evento> eventos(Long codUsuario);
}
