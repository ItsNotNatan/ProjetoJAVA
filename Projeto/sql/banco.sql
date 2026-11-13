-- Banco da Exchange de Criptomoedas
-- Execute no banco PostgreSQL chamado "moeda".
-- Este script não apaga os dados já existentes.

CREATE TABLE IF NOT EXISTS usuario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    s_real DOUBLE PRECISION NOT NULL DEFAULT 0,
    s_btc DOUBLE PRECISION NOT NULL DEFAULT 0,
    s_eth DOUBLE PRECISION NOT NULL DEFAULT 0,
    s_xrp DOUBLE PRECISION NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS dados (
    id SERIAL PRIMARY KEY,
    cpf_usuario VARCHAR(11) NOT NULL,
    data_op VARCHAR(50) NOT NULL,
    tipo_op VARCHAR(20) NOT NULL,
    valor DOUBLE PRECISION NOT NULL,
    moeda VARCHAR(20) NOT NULL,
    cotacao DOUBLE PRECISION NOT NULL DEFAULT 0,
    taxa DOUBLE PRECISION NOT NULL DEFAULT 0,
    saldo_real DOUBLE PRECISION NOT NULL,
    saldo_btc DOUBLE PRECISION NOT NULL,
    saldo_eth DOUBLE PRECISION NOT NULL,
    saldo_xrp DOUBLE PRECISION NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_dados_cpf_usuario_id
    ON dados (cpf_usuario, id DESC);

-- Tabela adicional para persistir as cotações entre execuções do programa.
CREATE TABLE IF NOT EXISTS cotacao (
    moeda VARCHAR(20) PRIMARY KEY,
    valor DOUBLE PRECISION NOT NULL CHECK (valor > 0),
    atualizada_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Cotações iniciais. ON CONFLICT evita sobrescrever as cotações existentes.
INSERT INTO cotacao (moeda, valor) VALUES
    ('BITCOIN', 300000.00),
    ('ETHEREUM', 15000.00),
    ('RIPPLE', 3.00)
ON CONFLICT (moeda) DO NOTHING;

-- Investidor de demonstração. Se já existir, seus dados/saldos são preservados.
INSERT INTO usuario (cpf, nome, senha, s_real, s_btc, s_eth, s_xrp)
VALUES ('12345678900', 'Gabriela Biondi', '123456', 500.00, 0, 0, 0)
ON CONFLICT (cpf) DO NOTHING;
