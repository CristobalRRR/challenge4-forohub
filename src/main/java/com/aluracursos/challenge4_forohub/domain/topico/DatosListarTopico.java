package com.aluracursos.challenge4_forohub.domain.topico;

import com.aluracursos.challenge4_forohub.domain.curso.Curso;
import com.aluracursos.challenge4_forohub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        Usuario usuarioId,
        String autor,
        String curso) {
    public DatosListarTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstado(),
                topico.getUsuarioId(), topico.getAutor(), topico.getCurso().toString());
    }
}
