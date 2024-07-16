package com.aluracursos.challenge4_forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosModificarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso) {
}
