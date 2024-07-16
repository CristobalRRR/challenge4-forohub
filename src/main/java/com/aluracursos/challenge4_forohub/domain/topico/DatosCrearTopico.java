package com.aluracursos.challenge4_forohub.domain.topico;

import com.aluracursos.challenge4_forohub.domain.curso.Curso;
import com.aluracursos.challenge4_forohub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCrearTopico(
        @NotBlank(message = "El titulo no puede estar vacio")
        String titulo,
        @NotBlank(message = "El mensaje no puede estar vacio")
        String mensaje,
        @NotNull(message = "El usuario no puede ser nulo")
        Long usuarioId,
        @NotBlank(message = "El autor no puede estar vacio")
        String autor,
        @NotNull(message = "El curse no puede estar vacio")
        Curso curso
) {
}
