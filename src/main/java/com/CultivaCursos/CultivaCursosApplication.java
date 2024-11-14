package com.CultivaCursos;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CultivaCursosApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Configuração das variáveis do banco de dados
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASS", dotenv.get("DB_PASS"));

        SpringApplication.run(CultivaCursosApplication.class, args);
    }
}
