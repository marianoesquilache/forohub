package com.forohub.demo.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
    Long id,
    String titulo,

    String mensaje,

    LocalDateTime fechaCreacion,

    String status,
    String autor,
    String curso
){
}
