package com.example.crud.domain.materia;

import jakarta.persistence.*;
import lombok.*;

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

    public MateriaEntity(RequestMateria requestMateria){
        this.name = requestMateria.name();
        this.active = true;
    }
}
