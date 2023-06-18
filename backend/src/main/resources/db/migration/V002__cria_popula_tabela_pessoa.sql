create table pessoa(
    codigo bigint(20) primary key auto_increment,
    nome varchar(50) not null,
    logradouro varchar(50),
    numero varchar(50),
    complemento varchar(50),
    bairro varchar(50),
    cep varchar(50),
    cidade varchar(50),
    estado varchar(50),
    ativo boolean not null
) engine=InnoDB default charset=utf8;

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Ricardo', 'abc', '123', 'xpto', 'aaa', '11111111', 'bbb', 'ccc', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Tayne', 'abc', '123', 'xpto', 'aaa', '11111111', 'bbb', 'ccc', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Kalel', 'abc', '123', 'xpto', 'aaa', '11111111', 'bbb', 'ccc', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Kyra', 'abc', '123', 'xpto', 'aaa', '11111111', 'bbb', 'ccc', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Jhon', 'abcd', '0123', 'xptoss', 'cbaaa', '11111000', 'cccbbb', 'dddccc', false);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo)
    values
('Mary', 'abczz', '00123', 'xptozz', 'vvaaa', '00011111', 'hhbbb', 'crrc', false);