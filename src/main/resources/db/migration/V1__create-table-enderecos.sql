CREATE TABLE enderecos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           logradouro VARCHAR(50) NOT NULL,
                           bairro VARCHAR(20) NOT NULL,
                           cep VARCHAR(9) NOT NULL,
                           complemento VARCHAR(50),
                           cidade VARCHAR(100) NOT NULL,
                           uf CHAR(2) NOT NULL
);

