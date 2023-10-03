package com.example.crud.controllers;

import com.example.crud.domain.materia.MateriaEntity;
import com.example.crud.domain.materia.RequestMateria;
import com.example.crud.domain.turma.RequestAddMateriaTurma;
import com.example.crud.domain.turma.RequestTurma;
import com.example.crud.domain.turma.TurmaEntity;
import com.example.crud.services.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaService service;
    @GetMapping
    public ResponseEntity getAllTurmas(){
        var allTurmas = service.getAllTurmas();
        return ResponseEntity.ok(allTurmas);
    }
    @PostMapping
    public ResponseEntity registerTurma(@RequestBody @Valid RequestTurma data ){
        TurmaEntity newTurma = service.registerTurma(data);
        return ResponseEntity.ok(newTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTurma(@PathVariable Long id, @RequestBody @Valid RequestTurma data ){
        TurmaEntity turma = service.updateTurma(id, data);
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTurma(@PathVariable Long id){
        service.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/materia")
    public ResponseEntity addMateria(@PathVariable Long id, @RequestBody @Valid RequestAddMateriaTurma data){
        TurmaEntity turma = service.addMateria(id, data.materias());
        return ResponseEntity.ok(turma);
    }
}
