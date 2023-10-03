package com.example.crud.domain.turma;

import jakarta.validation.constraints.NotBlank;

public record RequestTurma(
        @NotBlank
        String name,
        @NotBlank
        Integer roomNumber
){}