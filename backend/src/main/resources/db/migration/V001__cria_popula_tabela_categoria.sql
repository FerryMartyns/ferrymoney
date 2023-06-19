CREATE TABLE CATEGORIA (
	CODIGO BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(1, 'Lazer');
INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(2, 'Alimentação');
INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(3, 'Supermercado');
INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(4, 'Farmacia');
INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(5, 'Informática');
INSERT INTO CATEGORIA
(CODIGO, NOME)
VALUES(6, 'Outro(a)');