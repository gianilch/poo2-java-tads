CREATE TABLE materia_turma (
       id_turma integer NOT NULL,
       id_materia integer NOT NULL,
       PRIMARY KEY (id_turma, id_materia),
       FOREIGN KEY (id_turma) REFERENCES turma(id),
       FOREIGN KEY (id_materia) REFERENCES materia(id)
);