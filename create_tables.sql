-- ===========================================
-- SCRIPT DE CRIAÇÃO DE TABELAS E DADOS INICIAIS
-- ===========================================

-- ===========================================
-- TABELAS
-- ===========================================

CREATE TABLE candidates (
                            id SERIAL PRIMARY KEY,
                            first_name VARCHAR(100) NOT NULL,
                            last_name VARCHAR(100) NOT NULL,
                            birth_date DATE NOT NULL,
                            email VARCHAR(200) UNIQUE NOT NULL,
                            cpf VARCHAR(14) UNIQUE NOT NULL,
                            country VARCHAR(100),
                            cep VARCHAR(20),
                            description TEXT,
                            password VARCHAR(255) NOT NULL,
                            created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE companies (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(200) NOT NULL,
                           cnpj VARCHAR(20) UNIQUE NOT NULL,
                           email VARCHAR(200) UNIQUE NOT NULL,
                           description TEXT,
                           country VARCHAR(100),
                           cep VARCHAR(20),
                           password VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE skills (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE jobs (
                      id SERIAL PRIMARY KEY,
                      company_id INT REFERENCES companies(id) ON DELETE CASCADE,
                      title VARCHAR(200) NOT NULL,
                      description TEXT,
                      state VARCHAR(100),
                      city VARCHAR(100),
                      created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE candidate_skills (
                                  candidate_id INT REFERENCES candidates(id) ON DELETE CASCADE,
                                  skill_id INT REFERENCES skills(id) ON DELETE CASCADE,
                                  PRIMARY KEY (candidate_id, skill_id)
);

CREATE TABLE job_skills (
                            job_id INT REFERENCES jobs(id) ON DELETE CASCADE,
                            skill_id INT REFERENCES skills(id) ON DELETE CASCADE,
                            PRIMARY KEY (job_id, skill_id)
);

-- ===========================================
-- INSERÇÃO DE DADOS FICTÍCIOS
-- ===========================================

-- Candidatos
INSERT INTO candidates (first_name, last_name, birth_date, email, cpf, country, cep, description, password)
VALUES
    ('Lucas', 'Ferreira', '1995-04-12', 'lucas.ferreira@example.com', '123.456.789-00', 'Brasil', '04567-890', 'Desenvolvedor backend apaixonado por Go e banco de dados.', 'senha123'),
    ('Marina', 'Souza', '1998-11-23', 'marina.souza@example.com', '987.654.321-00', 'Brasil', '01023-456', 'Front-end developer com foco em React e design system.', 'senha456'),
    ('Carlos', 'Lima', '1992-07-15', 'carlos.lima@example.com', '321.654.987-00', 'Brasil', '30123-987', 'Engenheiro de software fullstack com experiência em startups.', 'senha789'),
    ('Ana', 'Pereira', '1999-02-03', 'ana.pereira@example.com', '111.222.333-44', 'Brasil', '22031-009', 'UX designer com background em psicologia cognitiva.', 'senha321'),
    ('João', 'Oliveira', '1990-09-10', 'joao.oliveira@example.com', '555.666.777-88', 'Brasil', '40028-920', 'DevOps e entusiasta de automação de infraestrutura.', 'senha654');

-- Empresas
INSERT INTO companies (name, cnpj, email, description, country, cep, password)
VALUES
    ('TechNova', '12.345.678/0001-99', 'contato@technova.com', 'Startup de tecnologia focada em soluções web.', 'Brasil', '04567-001', 'empresa123'),
    ('BlueSoft', '98.765.432/0001-55', 'contato@bluesoft.com', 'Desenvolvimento de software corporativo e consultoria.', 'Brasil', '11045-700', 'empresa456'),
    ('InovaGames', '11.222.333/0001-77', 'hr@inovagames.com', 'Estúdio independente de desenvolvimento de jogos.', 'Brasil', '22031-100', 'empresa789'),
    ('DataFlow', '44.555.666/0001-22', 'contato@dataflow.com', 'Consultoria em big data e machine learning.', 'Brasil', '30123-000', 'empresa321'),
    ('GreenTech', '77.888.999/0001-11', 'hello@greentech.com', 'Tecnologia sustentável e soluções ecológicas.', 'Brasil', '40028-000', 'empresa654');

-- ===========================================
-- EXEMPLO DE INSERÇÃO DE ALGUMAS SKILLS (opcional)
-- ===========================================
INSERT INTO skills (name)
VALUES
    ('Go'),
    ('React'),
    ('Python'),
    ('UI/UX Design'),
    ('DevOps'),
    ('SQL'),
    ('Node.js'),
    ('Docker');

-- ===========================================
-- ASSOCIAÇÃO EXEMPLO DE SKILLS AOS CANDIDATOS
-- ===========================================
INSERT INTO candidate_skills (candidate_id, skill_id) VALUES
                                                          (1, 1), -- Lucas -> Go
                                                          (1, 6), -- Lucas -> SQL
                                                          (2, 2), -- Marina -> React
                                                          (2, 4), -- Marina -> UI/UX
                                                          (3, 1), -- Carlos -> Go
                                                          (3, 7), -- Carlos -> Node.js
                                                          (4, 4), -- Ana -> UI/UX
                                                          (5, 5), -- João -> DevOps
                                                          (5, 8); -- João -> Docker
