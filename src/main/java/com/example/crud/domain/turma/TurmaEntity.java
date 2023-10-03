package com.example.crud.domain.turma;


import com.example.crud.domain.materia.MateriaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Table(name="turma")
@Entity(name="turma")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurmaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer room_number;

    private Boolean active;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "materia_turma",
            joinColumns = @JoinColumn(name = "id_turma"),
            inverseJoinColumns = @JoinColumn (name = "id_materia"))
    @JsonManagedReference
    private Set<MateriaEntity> materias;

    public TurmaEntity(RequestTurma requestTurma){
        this.name = requestTurma.name();
        this.room_number = requestTurma.room_number();
    }
}
