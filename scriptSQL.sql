CREATE DATABASE achados_perdidos;
USE achados_perdidos;


CREATE TABLE item_perdido (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome_item VARCHAR(255) NOT NULL,
    local_encontrado VARCHAR(255) NOT NULL,
    data_achado DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    descricao_devolucao VARCHAR(500)
);