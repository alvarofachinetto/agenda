package com.evento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evento.model.Evento;

@Repository
@Transactional
public interface eventoRepository extends CrudRepository<Evento, Long>{

}
