package com.example.crud.domain.turma;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RequestAddMateriaTurma(
        @NotEmpty
        List<Long> materias
){}