package com.aluracursos.challenge4_forohub.controller;

import com.aluracursos.challenge4_forohub.domain.topico.*;
import com.aluracursos.challenge4_forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> crearTopico(@RequestBody @Valid DatosCrearTopico datosCrearTopico,
                                                 UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosCrearTopico));
        TopicoDTO topicoDTO = new TopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getEstado(),topico.getUsuarioId(), topico.getAutor(), topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarTopico>> listarTopico(@PageableDefault(size = 5)Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByEstadoTrue(paginacion).map(DatosListarTopico::new));
    }

}
