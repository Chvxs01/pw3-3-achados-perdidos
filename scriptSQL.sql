CREATE DATABASE achadosperdidosdb;

USE achadosperdidosdb;


CREATE TABLE itens (
    id               BIGINT IDENTITY(1,1) PRIMARY KEY,
    titulo           VARCHAR(120) NOT NULL,
    descricao        VARCHAR(500) NULL,
    categoria        VARCHAR(30)  NOT NULL,
    tipo             VARCHAR(10)  NOT NULL,  -- PERDIDO ou ACHADO
    status           VARCHAR(15)  NOT NULL,  -- ABERTO ou DEVOLVIDO
    local_ocorrencia VARCHAR(150) NOT NULL,
    data_ocorrencia  DATE         NOT NULL,
    nome_contato     VARCHAR(100) NOT NULL,
    contato          VARCHAR(100) NOT NULL,
    data_registro    DATETIME2    NOT NULL,
    data_devolucao   DATETIME2    NULL,
    nome_retirante   VARCHAR(100) NULL
);


INSERT INTO itens (titulo, descricao, categoria, tipo, status, local_ocorrencia, data_ocorrencia, nome_contato, contato, data_registro) VALUES
('Mochila preta', 'Mochila Nike com chaveiro vermelho', 'MOCHILA', 'PERDIDO', 'ABERTO', 'Biblioteca', '2026-10-20', 'Ana Souza', 'ana@email.com', SYSDATETIME()),
('Mochila preta', 'Encontrada na mesa 4', 'MOCHILA', 'ACHADO', 'ABERTO', 'Biblioteca', '2026-10-21', 'Portaria', '(19) 99999-0000', SYSDATETIME()),
('Carteira marrom', 'Contém documentos', 'DOCUMENTO', 'ACHADO', 'ABERTO', 'Cantina', '2026-10-22', 'Portaria', '(19) 99999-0000', SYSDATETIME());