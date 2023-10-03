ALTER TABLE turma ADD COLUMN active BOOLEAN;
UPDATE turma SET active = true;