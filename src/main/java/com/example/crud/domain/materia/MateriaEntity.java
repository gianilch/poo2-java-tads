package com.example.crud.domain.materia;

import com.example.crud.domain.turma.TurmaEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Table(name="materia")
@Entity(name="materia")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MateriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean active;

    @ManyToMany(mappedBy = "materias")
    @JsonBackReference
    private Set<TurmaEntity> turmas;

    public MateriaEntity(RequestMateria requestMateria){
        this.name = requestMateria.name();
        this.active = true;
    }
}
