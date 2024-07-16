package com.forohub.demo.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this .titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    public void actualizarTopico(DatosActualizarTopico datos){
        if(datos.titulo()!=null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje()!=null){
            this.mensaje = datos.mensaje();
        }
        if(datos.fechaCreacion()!=null){
            this.fechaCreacion = datos.fechaCreacion();
        }
        if(datos.status()!=null){
            this.status = datos.status();
        }
        if(datos.autor()!=null){
            this.autor = datos.autor();
        }
        if(datos.curso()!=null){
            this.curso= datos.curso();
        }
    }
}

