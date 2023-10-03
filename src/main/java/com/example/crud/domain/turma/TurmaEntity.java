package com.example.crud.domain.turma;


import jakarta.persistence.*;
import lombok.*;

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

    private Integer roomNumber;

    public TurmaEntity(RequestTurma requestTurma){
        this.name = requestTurma.name();
        this.roomNumber = requestTurma.roomNumber();
    }
}
