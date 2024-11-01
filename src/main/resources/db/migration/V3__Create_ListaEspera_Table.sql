CREATE TABLE ListaEspera (
    id INT AUTO_INCREMENT PRIMARY KEY,
    curso_id BIGINT,
    usuario_id BIGINT,
    data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status_espera ENUM('pendente', 'matriculado', 'removido') DEFAULT 'pendente',
    
    FOREIGN KEY (curso_id) REFERENCES Courses(id) ON DELETE CASCADE,
    
    FOREIGN KEY (usuario_id) REFERENCES Users(id) ON DELETE CASCADE
);