ALTER TABLE vollmed_api.medicos ADD ativo TINYINT(1);
UPDATE vollmed_api.medicos SET ativo = 1;
