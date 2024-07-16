package com.aluracursos.challenge4_forohub.repository;

import com.aluracursos.challenge4_forohub.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    //Este se usa para evitar crear topicos duplicados, va en el service
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}
