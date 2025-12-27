CREATE TABLE tb_cidade (
  id_cidade BIGINT NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  qtd_habitantes BIGINT
);

INSERT INTO tb_cidade (id_cidade, nome, qtd_habitantes)
VALUES (1, 'Sao Paulo', 12396372),
       (2, 'Rio de Janeiro', 10000000);
