create table medicos(
    id SERIAL PRIMARY KEY not null,
    nome VARCHAR(100) not null,
    email VARCHAR(100) not null unique,
    crm VARCHAR(6) not null unique,
    especialidades VARCHAR(100) not null,
    logradouro VARCHAR(100) not null,
    bairro VARCHAR(100) not null,
    cep VARCHAR(9) not null,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    uf CHAR(2) not null,
    cidade VARCHAR(100) not null
);