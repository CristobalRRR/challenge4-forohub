package com.aluracursos.challenge4_forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean estado,
        String autor,
        String curso) {

    public DatosListarTopico(Topico topico){
       this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
              topico.getEstado() ,topico.getAutor(), topico.getCurso().toString());
    }
}


