CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(50),
    senha VARCHAR(8),
    logradouro VARCHAR(255),
    numero INTEGER,
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    uf VARCHAR(50),
    cep VARCHAR(8),
    tipo_usuario VARCHAR(50),
    data_alteracao TIMESTAMP

);

INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) VALUES
    ('João Silva', 'joao_silva@gmail.com', 'joao01', 'pass0101', 'Rua XV', '500', 'Centro', 'Porto Alegre', 'RS', '80220335','2025-10-15 10:00:00', 'CLIENTE' );

INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) VALUES
    ('Maria dos Santos', 'maria_santos@gmail.com', 'maria01', 'pass0202', 'Rua XV', '500', 'Centro', 'Curitiba', 'PR', '80550335', '2025-10-15 10:00:00', 'DONO' );

INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) VALUES
    ('Ana Dantas', 'ana_dantas@gmail.com', 'ana01', 'pass0303', 'Rua XV', '500', 'Centro', 'Florianopolis', 'SC', '80234335', '2025-10-15 10:00:00', 'CLIENTE' );

INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) VALUES
    ('José Batista', 'jose_batista@gmail.com', 'jose01', 'pass0404', 'Rua XV', '500', 'Centro', 'São Paulo', 'SP', '80220785', '2025-10-15 10:00:00', 'CLIENTE' );

INSERT INTO usuarios (nome, email, login, senha, logradouro, numero, bairro, cidade, uf, cep, data_alteracao, tipo_usuario) VALUES
    ('Roberto Oliveiro', 'roberto_oliveira@gmail.com', 'roberto01', 'pass0505', 'Rua XV', '500', 'Centro', 'Belo Horizonte', 'MG', '80220455', '2025-10-15 10:00:00', 'CLIENTE' );