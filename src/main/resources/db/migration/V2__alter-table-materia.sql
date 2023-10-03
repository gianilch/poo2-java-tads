ALTER TABLE materia ADD COLUMN active BOOLEAN;
UPDATE materia SET active = true;