CREATE TABLE medicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(50) NOT NULL,
                         especialidade VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         crm VARCHAR(20) NOT NULL UNIQUE,
                         endereco_id BIGINT NOT NULL,
                         FOREIGN KEY (endereco_id) REFERENCES enderecos (id)
);