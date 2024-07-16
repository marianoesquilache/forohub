package com.forohub.demo.domain.topico;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Past
        @JsonProperty("fecha_creacion")
        LocalDateTime fechaCreacion,
        @NotBlank
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso


) {
}
