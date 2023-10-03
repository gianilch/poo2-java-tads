package com.example.crud.repositories;

import com.example.crud.domain.materia.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepository extends JpaRepository<MateriaEntity, Long> {
    List<MateriaEntity> findAllByActiveTrue();
}
