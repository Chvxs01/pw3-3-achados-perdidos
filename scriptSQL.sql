CREATE DATABASE achadosperdidosdb;

USE achadosperdidosdb;

CREATE TABLE itens_perdidos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nome_item VARCHAR(255) NOT NULL,
    local_encontrado VARCHAR(255) NOT NULL,
    data_achado DATE NOT NULL,
    status_item VARCHAR(20) NOT NULL,
    descricao_devolucao VARCHAR(255) NULL
);


INSERT INTO itens_perdidos (nome_item, local_encontrado, data_achado, status_item) VALUES
('Garrafa azul', 'Biblioteca', '2026-11-18', 'PERDIDO'),
('Carteira marrom', 'Cantina', '2026-11-19', 'REIVINDICADO'),
('Chave do armário', 'Ginásio', '2026-11-20', 'DEVOLVIDO');

-- Use se der ERRO HTTP 500
USE achadosperdidosdb;
GO
DROP TABLE IF EXISTS itens_perdidos; 
GO