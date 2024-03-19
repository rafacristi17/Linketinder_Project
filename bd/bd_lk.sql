CREATE TABLE IF NOT EXISTS mydb.candidato (
  idcandidato SERIAL PRIMARY KEY,
  nome VARCHAR(45),
  idade VARCHAR(45),
  email VARCHAR(45),
  cpf VARCHAR(45),
  estado VARCHAR(45),
  cep VARCHAR(45),
  descricao VARCHAR(45)
);
CREATE TABLE IF NOT EXISTS mydb.empresa (
  idempresa SERIAL PRIMARY KEY,
  nome VARCHAR(45),
  cnpj VARCHAR(45),
  email VARCHAR(45),
  descricao VARCHAR(45),
  pais VARCHAR(45),
  cep VARCHAR(45),
  senha VARCHAR(45)
);
CREATE TABLE IF NOT EXISTS mydb.vagas (
  idvagas SERIAL PRIMARY KEY,
  empresa_idempresa INT NOT NULL,
  FOREIGN KEY (empresa_idempresa) REFERENCES mydb.empresa(idempresa) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS mydb.competencias (
  nome_competencias SERIAL PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS mydb.candidato_has_competencias (
  candidato_idcandidato INT NOT NULL,
  competencias_nome_competencias INT NOT NULL,
  PRIMARY KEY (candidato_idcandidato, competencias_nome_competencias),
  FOREIGN KEY (candidato_idcandidato) REFERENCES mydb.candidato(idcandidato) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (competencias_nome_competencias) REFERENCES mydb.competencias(nome_competencias) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS mydb.competencias_has_vagas (
  competencias_nome_competencias INT NOT NULL,
  vagas_idvagas INT NOT NULL,
  PRIMARY KEY (competencias_nome_competencias, vagas_idvagas),
  FOREIGN KEY (competencias_nome_competencias) REFERENCES mydb.competencias(nome_competencias) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (vagas_idvagas) REFERENCES mydb.vagas(idvagas) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS mydb.candidato_curte (
  candidato_idcandidato INT NOT NULL,
  vagas_idvagas INT NOT NULL,
  PRIMARY KEY (candidato_idcandidato, vagas_idvagas),
  FOREIGN KEY (candidato_idcandidato) REFERENCES mydb.candidato(idcandidato) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (vagas_idvagas) REFERENCES mydb.vagas(idvagas) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS mydb.empresa_curte (
  empresa_idempresa INT NOT NULL,
  candidato_idcandidato INT NOT NULL,
  PRIMARY KEY (empresa_idempresa, candidato_idcandidato),
  FOREIGN KEY (empresa_idempresa) REFERENCES mydb.empresa(idempresa) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (candidato_idcandidato) REFERENCES mydb.candidato(idcandidato) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO mydb.candidato (nome, email, cpf, idade, estado, cep, descricao, senha) VALUES
('ana', 'ana@gmail.com', '123.456.789-01', '30', 'Pernambuco', '50000-000', 'python', 'ana123'),
('joao', 'joao@gmail.com', '123.456.789-02', '31', 'Pernambuco', '50000-001', 'java', 'joao123'),
('carlos', 'carlos@gmail.com', '123.456.789-03', '32', 'Pernambuco', '50000-002', 'javascript', 'carlos123'),
('tatiana', 'tatiana@gmail.com', '123.456.789-04', '33', 'Pernambuco', '50000-003', 'mysql','tatiana123'),
('john', 'john@gmail.com', '123.456.789-05', '34', 'Pernambuco', '50000-004', 'git', 'john123');

INSERT INTO mydb.empresa (nome, cnpj, email, descricao, pais, cep, senha) VALUES
('bytech', '12.345.678/0001-01', 'bytech@gmail.com', 'Descrição 1', 'Brasil', '50000-005', 'bytech123'),
('infotec', '12.345.678/0001-02', 'infotec@gmail.com', 'Descrição 2', 'Brasil', '50000-006', 'infotec123'),
('digital', '12.345.678/0001-03', 'digital@gmail.com', 'Descrição 3', 'Brasil', '50000-007', 'digital123'),
('2wtech', '12.345.678/0001-04', '2wtech@gmail.com', 'Descrição 4', 'Brasil', '50000-008', '2wtech123'),
('politech', '12.345.678/0001-05', 'politech@gmail.com', 'Descrição 5', 'Brasil', '50000-009', 'politech123');

