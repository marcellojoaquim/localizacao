CREATE TABLE tb_cidade (
  id_cidade BIGINT NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  qtd_habitantes BIGINT
);

INSERT INTO tb_cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'Sao Paulo', 12396372),
    (2, 'Rio de Janeiro', 1000000),
    (3, 'Recife', 670400),
    (4, 'Fortaleza', 21345678),
    (5, 'Palmas', 987123456),
    (6, 'Jaboatao dos Guararapes', 670400),
    (7, 'Belo Horizonte', 670400),
    (8, 'Caruaru', 500400),
    (9, 'Joao Pessoa', 700400),
    (10, 'Sao Jose do Egito', 18000);