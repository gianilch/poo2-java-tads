package com.example.crud.controllers;

import com.example.crud.domain.materia.MateriaEntity;
import com.example.crud.domain.materia.RequestMateria;
import com.example.crud.services.MateriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {
    @Autowired
    private MateriaService service;
    @GetMapping
    public ResponseEntity getAllMaterias(){
        var allMaterias = service.getAllMaterias();
        return ResponseEntity.ok(allMaterias);
    }

    @PostMapping
    public ResponseEntity registerMateria(@RequestBody @Valid RequestMateria data ){
        MateriaEntity newMateria = service.registerMateria(data);
        return ResponseEntity.ok(newMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMateria(@PathVariable Long id, @RequestBody @Valid RequestMateria data ){
        MateriaEntity materia = service.updateMateria(id, data);
        return ResponseEntity.ok(materia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMateria(@PathVariable Long id){
        service.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }
}
