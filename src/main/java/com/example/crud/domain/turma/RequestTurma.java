package com.example.crud.domain.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestTurma(
        @NotBlank
        String name,
        @NotNull
        Integer room_number
){}