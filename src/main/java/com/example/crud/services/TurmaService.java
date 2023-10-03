package com.example.crud.services;

import com.example.crud.domain.materia.MateriaEntity;
import com.example.crud.domain.turma.RequestTurma;
import com.example.crud.domain.turma.TurmaEntity;
import com.example.crud.repositories.MateriaRepository;
import com.example.crud.repositories.TurmaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository repository;

    @Autowired
    MateriaRepository materiaRepository;

    public List<TurmaEntity> getAllTurmas(){
        var allTurmas = repository.findAll();
      return allTurmas;
    }

    public TurmaEntity registerTurma(RequestTurma data ){
        TurmaEntity newTurma = new TurmaEntity(data);
        newTurma.setActive(true);
        repository.save(newTurma);
        return newTurma;
    }
    @Transactional
    public TurmaEntity updateTurma(Long id, RequestTurma data ){
        Optional<TurmaEntity> optionalTurma = repository.findById(id);
        if(optionalTurma.isPresent()) {
            TurmaEntity turma = optionalTurma.get();
            turma.setName(data.name());
            turma.setRoom_number(data.room_number());
            return turma;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public TurmaEntity deleteTurma(Long id){
        Optional<TurmaEntity> optionalTurma = repository.findById(id);
        if(optionalTurma.isPresent()) {
            TurmaEntity turma = optionalTurma.get();
            turma.setActive(false);
            return turma;
        } else {
            throw new EntityNotFoundException();
        }
    }
    @Transactional
    public TurmaEntity addMateria(Long id, List<Long> idMaterias){
        Optional<TurmaEntity> optionalTurma = repository.findById(id);
        if(optionalTurma.isPresent()) {
            TurmaEntity turma = optionalTurma.get();
            Set<MateriaEntity> materias = new HashSet<>(materiaRepository.findAllById(idMaterias));

            turma.setMaterias(materias);
            return turma;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
