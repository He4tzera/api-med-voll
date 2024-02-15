UPDATE  clientes
SET ativo = true;
ALTER TABLE clientes ALTER COLUMN ativo SET NOT NULL;