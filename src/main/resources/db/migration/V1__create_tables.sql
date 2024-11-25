CREATE TABLE usuarios
(
    id           bigint primary key Auto_increment,
    login        VARCHAR(50) unique not null,
    senha        VARCHAR(50)        NOT NULL,
    grupo_acesso varchar(50)        NOT NULL
);

CREATE TABLE departamentos
(
    id        bigint primary key Auto_increment,
    descricao VARCHAR(255) NOT NULL
);


CREATE TABLE cargos
(
    id        bigint primary key Auto_increment,
    descricao VARCHAR(255) NOT NULL
);

CREATE TABLE colaboradores
(
    id              BIGINT PRIMARY KEY Auto_increment,
    nome            VARCHAR(255) not null,
    email           VARCHAR(255),
    telefone        VARCHAR(11),
    cpf             VARCHAR(11)  NOT NULL UNIQUE,
    rg              VARCHAR(20)  NOT NULL,
    departamento_id BIGINT       NOT NULL,
    cargo_id        BIGINT       NOT NULL,
    data_admissao   TIMESTAMP    NOT NULL,
    data_demissao   TIMESTAMP,
    usuario_id      BIGINT       NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (departamento_id) references departamentos (id),
    FOREIGN KEY (cargo_id) REFERENCES cargos (id)
);

CREATE TABLE beneficios
(
    id             BIGINT PRIMARY KEY Auto_increment,
    descricao      VARCHAR(100)  NOT NULL,
    valor_aplicado DECIMAL(8, 2) NOT NULL
);

CREATE TABLE encargos
(
    id         BIGINT PRIMARY KEY Auto_increment,
    descricao  varchar(100)  not null,
    pocentagem DECIMAL(5, 2) not null
);

CREATE TABLE salarios
(
    id             BIGINT primary key Auto_increment,
    colaborador_id BIGINT        not null,
    salario_base   DECIMAL(8, 2) NOT NULL,
    data_inicio    TIMESTAMP     NOT NULL,
    data_fim       TIMESTAMP,
    FOREIGN KEY (colaborador_id) REFERENCES colaboradores (id)
);

create table salario_encargo
(
    salario_id BIGINT NOT NULL,
    encargo_id BIGINT NOT NULL,
    FOREIGN KEY (salario_id) REFERENCES salarios (id),
    FOREIGN KEY (encargo_id) REFERENCES encargos (id)
);

create table salario_beneficio
(
    salario_id   BIGINT NOT NULL,
    beneficio_id BIGINT NOT NULL,
    FOREIGN KEY (salario_id) REFERENCES salarios (id),
    FOREIGN KEY (beneficio_id) REFERENCES beneficios (id)
);

CREATE TABLE holerites
(
    id              BIGINT PRIMARY KEY Auto_increment,
    mes_referencia  DATE          NOT NULL,
    total_horas     DECIMAL(6, 2) NOT NULL,
    salario_liquido DECIMAL(8, 2) NOT NULL,
    salario_id      BIGINT        not null,
    foreign key (salario_id) references salarios (id)
);

CREATE TABLE pontos
(
    id             BIGINT PRIMARY KEY Auto_increment,
    colaborador_id BIGINT NOT NULL,
    hora_ponto     TIME   NOT NULL,
    FOREIGN KEY (colaborador_id) REFERENCES colaboradores (id)
);

