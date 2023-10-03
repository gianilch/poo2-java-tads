package com.example.crud.repositories;

import com.example.crud.domain.turma.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {}
