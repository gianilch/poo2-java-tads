package com.example.crud.controllers;

import com.example.crud.domain.materia.MateriaEntity;
import com.example.crud.repositories.MateriaRepository;
import com.example.crud.domain.materia.RequestMateria;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {
    @Autowired
    private MateriaRepository repository;
    @GetMapping
    public ResponseEntity getAllMaterias(){
        var allMaterias = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allMaterias);
    }

    @PostMapping
    public ResponseEntity registerMateria(@RequestBody @Valid RequestMateria data ){
    MateriaEntity newMateria = new MateriaEntity(data);
    repository.save(newMateria);
    return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateMateria(@PathVariable Long id, @RequestBody @Valid RequestMateria data ){
        Optional<MateriaEntity> optionalMateria = repository.findById(id);
        if(optionalMateria.isPresent()) {
            MateriaEntity materia = optionalMateria.get();
            materia.setName(data.name());
            return ResponseEntity.ok(materia);
        } else {
        return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMateria(@PathVariable Long id){
        Optional<MateriaEntity> optionalMateria = repository.findById(id);
        if(optionalMateria.isPresent()) {
            MateriaEntity materia = optionalMateria.get();
            materia.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
