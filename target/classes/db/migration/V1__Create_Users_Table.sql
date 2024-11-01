CREATE TABLE IF NOT EXISTS Users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX idx_users_cpf ON Users(cpf);
CREATE INDEX idx_users_email ON Users(email);

CREATE TABLE IF NOT EXISTS UserProfiles (
    user_id BIGINT PRIMARY KEY,
    cep VARCHAR(9),
    address VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(2),
    phone VARCHAR(15),
    matricula VARCHAR(255),
    setor VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE INDEX idx_user_profiles_user_id ON UserProfiles(user_id);
