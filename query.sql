CREATE TABLE usuario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255),
    senha VARCHAR(50),
    s_real FLOAT,
    s_btc FLOAT,
    s_eth FLOAT,
    s_xrp FLOAT
);

CREATE TABLE dados (
    id SERIAL PRIMARY KEY,
    cpf_usuario VARCHAR(11),
    data_op VARCHAR(50),
    tipo_op VARCHAR(20),
    valor FLOAT,
    moeda VARCHAR(20),
    cotacao FLOAT,
    taxa FLOAT,
    saldo_real FLOAT,
    saldo_btc FLOAT,
    saldo_eth FLOAT,
    saldo_xrp FLOAT
);

CREATE TABLE cotacao (
    moeda VARCHAR(20) PRIMARY KEY,
    valor FLOAT,
    atualizada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO cotacao (moeda, valor)
VALUES ('BITCOIN', 300000.00);

INSERT INTO cotacao (moeda, valor)
VALUES ('ETHEREUM', 15000.00);

INSERT INTO cotacao (moeda, valor)
VALUES ('RIPPLE', 3.00);

INSERT INTO usuario (cpf, nome, senha, s_real, s_btc, s_eth, s_xrp)
VALUES ('12345678900', 'Gabriela Bondi', '123456', 500.0, 0.0, 0.0, 0.0);