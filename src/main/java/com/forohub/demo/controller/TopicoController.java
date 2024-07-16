package com.forohub.demo.controller;

import com.forohub.demo.domain.topico.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>>listarTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id){

        var topicoOpt = topicoRepository.findById(id);
        if(!topicoOpt.isPresent()){
            throw new EntityNotFoundException("Tópico no encontrado con id: " + id);
        }
        var topico = topicoOpt.get();
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        var topicoOpt = topicoRepository.findById(datosActualizarTopico.id());
        if(!topicoOpt.isPresent()){
            throw new EntityNotFoundException("Tópico no encontrado con id: " + datosActualizarTopico.id());
        }
        var topico = topicoOpt.get();
        topico.actualizarTopico(datosActualizarTopico);


        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso()));

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        var topicoOpt = topicoRepository.findById(id);
        if(!topicoOpt.isPresent()){
            throw new EntityNotFoundException("Tópico no encontrado con id: " + id);
        }
        topicoRepository.deleteById(topicoOpt.get().getId());

        return ResponseEntity.noContent().build();


    }

    //segundo commit

}