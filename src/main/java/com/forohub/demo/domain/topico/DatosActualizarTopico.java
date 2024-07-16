package com.forohub.demo.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
                                    @NotNull
                                    Long id,

                                    String titulo,
                                    String mensaje,

                                    LocalDateTime fechaCreacion,
                                    String status,
                                    String autor,
                                    String curso) {


}
