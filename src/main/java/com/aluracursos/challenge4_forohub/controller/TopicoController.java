package com.aluracursos.challenge4_forohub.controller;

import com.aluracursos.challenge4_forohub.domain.topico.*;
import com.aluracursos.challenge4_forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid DatosCrearTopico datosCrearTopico){
        var topico = topicoService.crearTopico(datosCrearTopico);
        var url = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topico);
    }
    @GetMapping
    public ResponseEntity<List<DatosListarTopico>> mostrarTodosLosTopicos(){
        List<DatosListarTopico> topicos = topicoService.mostrarTodosLosTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListarTopico> mostrarTopicoPorId(@PathVariable Long id){
        return topicoService.mostrarTopicoEspecifico(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> modificarTopico(@PathVariable Long id, @RequestBody DatosModificarTopico datosModificarTopico){
        Topico topico = topicoService.modificarTopico(id, datosModificarTopico);
        return ResponseEntity.ok(topicoService.mostrarTopicoEspecifico(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> eliminarTopico(@PathVariable Long id){
        if(topicoRepository.existsById(id)){
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
