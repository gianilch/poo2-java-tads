package com.example.crud.services;

import com.example.crud.domain.materia.MateriaEntity;
import com.example.crud.domain.materia.RequestMateria;
import com.example.crud.repositories.MateriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class MateriaService {
    @Autowired
    private MateriaRepository repository;

    public List<MateriaEntity> getAllMaterias(){
        var allMaterias = repository.findAllByActiveTrue();
        return allMaterias;
    }

    public MateriaEntity registerMateria( RequestMateria data ){
        MateriaEntity newMateria = new MateriaEntity(data);
        repository.save(newMateria);
        return newMateria;
    }

    @Transactional
    public MateriaEntity updateMateria(Long id, RequestMateria data ){
        Optional<MateriaEntity> optionalMateria = repository.findById(id);
        if(optionalMateria.isPresent()) {
            MateriaEntity materia = optionalMateria.get();
            materia.setName(data.name());
            return materia;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public MateriaEntity deleteMateria(Long id){
        Optional<MateriaEntity> optionalMateria = repository.findById(id);
        if(optionalMateria.isPresent()) {
            MateriaEntity materia = optionalMateria.get();
            materia.setActive(false);
            return materia;
        } else {
            throw new EntityNotFoundException();
        }
    }
}
