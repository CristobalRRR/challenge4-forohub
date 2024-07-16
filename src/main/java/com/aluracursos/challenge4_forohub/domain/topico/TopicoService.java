package com.aluracursos.challenge4_forohub.domain.topico;

import com.aluracursos.challenge4_forohub.domain.curso.Curso;
import com.aluracursos.challenge4_forohub.domain.usuario.Usuario;
import com.aluracursos.challenge4_forohub.repository.TopicoRepository;
import com.aluracursos.challenge4_forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Topico crearTopico(DatosCrearTopico datosCrearTopico) {
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(datosCrearTopico.titulo(), datosCrearTopico.mensaje());
        if (topicoExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un topico con el mismo titulo y mensaje");
        }
        Usuario usuario = usuarioRepository.findById(datosCrearTopico.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Topico topico = new Topico(datosCrearTopico, usuario);
        return topicoRepository.save(topico);
    }

    public List<DatosListarTopico> mostrarTodosLosTopicos() {
        return topicoRepository.findAll().stream()
                .map(DatosListarTopico::new)
                .collect(Collectors.toList());
    }

    public Optional<DatosListarTopico> mostrarTopicoEspecifico(Long id) {
        return topicoRepository.findById(id)
                .map(DatosListarTopico::new);
    }

    public Topico modificarTopico(Long id, DatosModificarTopico datosModificarTopico) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topico no encontrado para modificar"));

        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(datosModificarTopico.titulo(), datosModificarTopico.mensaje());
        if (topicoExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un topico con el mismo titulo y mensaje");
        }

        if (datosModificarTopico.titulo() != null) {
            topico.setTitulo(datosModificarTopico.titulo());
        }
        if (datosModificarTopico.mensaje() != null) {
            topico.setMensaje(datosModificarTopico.mensaje());
        }
        if (datosModificarTopico.autor() != null) {
            topico.setAutor(datosModificarTopico.autor());
        }
        if (datosModificarTopico.curso() != null) {
            topico.setCurso(Curso.valueOf(datosModificarTopico.curso()));
        }
        return topicoRepository.save(topico);
    }
}

