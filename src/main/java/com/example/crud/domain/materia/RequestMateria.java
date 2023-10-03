package com.example.crud.domain.materia;

import jakarta.validation.constraints.NotBlank;

public record RequestMateria(
        @NotBlank
        String name
) {
}
